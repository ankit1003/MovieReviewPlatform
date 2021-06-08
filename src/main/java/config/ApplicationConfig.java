package config;

import resource.MovieResource;
import resource.ReviewResource;
import resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {

        register(MovieResource.class);
        register(UserResource.class);
        register(ReviewResource.class);

    }

}
