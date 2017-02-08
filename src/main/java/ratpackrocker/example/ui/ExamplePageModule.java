package ratpackrocker.example.ui;

import com.google.inject.AbstractModule;
import ratpackrocker.example.ui.pages.HomePageHandlers;

public class ExamplePageModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HomePageHandlers.class);
    }

}
