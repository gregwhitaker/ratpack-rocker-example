package ratpackrocker.example.service;

import com.google.inject.AbstractModule;

public class ExampleServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ExampleServiceHandlers.class);
    }

}
