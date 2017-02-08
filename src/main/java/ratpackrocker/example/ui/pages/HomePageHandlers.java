package ratpackrocker.example.ui.pages;

import com.google.inject.Singleton;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Context;
import ratpackrocker.example.Home;

@Singleton
public class HomePageHandlers implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.prefix("", c -> c
                .all(ctx -> ctx.byMethod(byMethodSpec -> byMethodSpec
                        .get(() -> handleGet(ctx))
                        .post(() -> handlePost(ctx)))));
    }

    private void handleGet(Context ctx) {
        ctx.getResponse().contentType(Home.CONTENT_TYPE.toString());
        ctx.render(Home.template().render().toString());
    }

    private void handlePost(Context ctx) {
        ctx.getResponse().contentType(Home.CONTENT_TYPE.toString());
        ctx.render(Home.template().render().toString());
    }

}
