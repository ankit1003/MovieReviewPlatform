package client;

import bean.Movie;
import bean.Review;
import bean.User;
import constants.Genre;
import service.MovieOperation;
import service.UserOperation;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static constants.Genre.COMEDY;
import static constants.Genre.ROMANTIC;

public class MyProgram {
    public static void main(String[] args) throws ParseException {

        UserOperation userOperation = new UserOperation();
        MovieOperation movieOperation = new MovieOperation();

        Set<Genre> genreList = new HashSet<Genre>();
        genreList.add(COMEDY);


        Movie movie = new Movie("DDLJ",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1996"),genreList);

        User user = new User("User");
        User user1 = new User("Ankit");


        Review review = new Review(user,5,movie);
        Review review1 = new Review(user1, 4 ,movie);




        userOperation.addUser(user);
        userOperation.addUser(user1);
        movieOperation.addMovie(movie);
        movieOperation.postReview(review);
        userOperation.postReview(review1);





    }
}