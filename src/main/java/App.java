import resource.MovieResource;
import resource.ReviewResource;
import resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
public class App extends Application<Configuration> {

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {

        //registering all the RESTful service classes.
//        e.jersey().register(new MyProgram());
        e.jersey().register(new MovieResource());
        e.jersey().register(new UserResource());
        e.jersey().register(new ReviewResource());

    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}