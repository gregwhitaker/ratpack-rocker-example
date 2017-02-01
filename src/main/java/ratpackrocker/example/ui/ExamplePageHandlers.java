package ratpackrocker.example.ui;

import com.google.inject.Singleton;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpackrocker.example.ui.pages.HomePageHandler;

@Singleton
public class ExamplePageHandlers implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.prefix("", c -> c.get(HomePageHandler.class));
    }

}
