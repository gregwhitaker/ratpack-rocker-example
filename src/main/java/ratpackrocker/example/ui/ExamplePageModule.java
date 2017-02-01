package ratpackrocker.example.ui;

import com.google.inject.AbstractModule;
import ratpackrocker.example.ui.pages.HomePageHandler;

public class ExamplePageModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HomePageHandler.class);
        bind(ExamplePageHandlers.class);
    }

}
