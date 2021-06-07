package config;

import resource.MovieAPI;
import resource.ReviewAPI;
import resource.UserAPI;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {

        register(MovieAPI.class);
        register(UserAPI.class);
        register(ReviewAPI.class);

    }

}
