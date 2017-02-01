package ratpackrocker.example;

import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import ratpackrocker.example.service.ExampleServiceHandlers;
import ratpackrocker.example.service.ExampleServiceModule;
import ratpackrocker.example.ui.ExamplePageHandlers;
import ratpackrocker.example.ui.ExamplePageModule;

public class ExampleMain {

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s
                .serverConfig(c -> c.baseDir(BaseDir.find()))
                .registry(Guice.registry(b -> b
                        .module(ExampleServiceModule.class)
                        .module(ExamplePageModule.class)))
                .handlers(chain -> chain
                        .insert(ExampleServiceHandlers.class)
                        .insert(ExamplePageHandlers.class)
                )
        );
    }

}
