package ratpackrocker.example.ui.pages;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.form.Form;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Context;
import ratpackrocker.example.Home;
import ratpackrocker.example.service.NumberBucketsService;
import ratpackrocker.example.service.NumberGeneratorService;

@Singleton
public class HomePageHandlers implements Action<Chain> {

    private final NumberGeneratorService numberGeneratorService;
    private final NumberBucketsService numberBucketsService;

    @Inject
    public HomePageHandlers(NumberGeneratorService numberGeneratorService,
                            NumberBucketsService numberBucketsService) {
        this.numberGeneratorService = numberGeneratorService;
        this.numberBucketsService = numberBucketsService;
    }

    @Override
    public void execute(Chain chain) throws Exception {
        chain.prefix("", c -> c
                .all(ctx -> ctx.byMethod(byMethodSpec -> byMethodSpec
                        .get(() -> handleGet(ctx))
                        .post(() -> handlePost(ctx))))
                .notFound());
    }

    private void handleGet(Context ctx) {
        ctx.getResponse().contentType(Home.CONTENT_TYPE.toString());
        ctx.render(Home.template(null).render().toString());
    }

    private void handlePost(Context ctx) {
        ctx.parse(Form.class)
                .map(form -> Integer.valueOf(form.getOrDefault("maxValue", "10")))
                .map(numberGeneratorService::generate)
                .map(numberBucketsService::sort)
                .then(numberBuckets -> {
                    ctx.getResponse().contentType(Home.CONTENT_TYPE.toString());
                    ctx.render(Home.template(numberBuckets).render().toString());
                });
    }

}
