package client;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {

        register(MovieAPI.class);
        register(UserAPI.class);

    }

}
