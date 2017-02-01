package ratpackrocker.example.ui.pages;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpackrocker.example.Home;

public class HomePageHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.getResponse().contentType("text/html");
        ctx.render(Home.template().render().toString());
    }

}
