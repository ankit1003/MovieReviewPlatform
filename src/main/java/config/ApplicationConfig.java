package config;

import exception.MovieNotFoundException;
import exception.ReviewNotAddedException;
import exception.ReviewNotFoundException;
import exception.UserNotFoundException;
import model.Review;
import resource.MovieResource;
import resource.ReviewResource;
import resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {

        register(MovieResource.class);
        register(UserResource.class);
        register(ReviewResource.class);
        register(MovieNotFoundException.class);
        register(ReviewNotFoundException.class);
        register(UserNotFoundException.class);
        register(ReviewNotAddedException.class);
    }

}
