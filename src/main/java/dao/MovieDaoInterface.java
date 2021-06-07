package dao;

import exception.MovieNotFoundException;
import model.Movie;
import model.Review;
import model.User;

import java.util.List;
import java.util.Map;

public interface MovieDaoInterface {
    void addMovie(Movie movie);
    void postReview(Review review);
    void deleteReview(Review review);
    List viewMovies();
    Movie viewMovie(int movieId) throws MovieNotFoundException;
    Map viewReviews(int movieId) throws MovieNotFoundException;

}
