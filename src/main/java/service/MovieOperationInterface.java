package service;

import exception.MovieNotFoundException;
import exception.ReviewNotAddedException;
import exception.UserNotFoundException;
import model.Movie;
import model.Review;
import model.User;

import java.util.List;
import java.util.Map;

public interface MovieOperationInterface {
    void addMovie(Movie movie);
    void postReview(Review review) throws UserNotFoundException, MovieNotFoundException;
    void deleteReview(Review review);
    List viewMovies();

    Movie viewMovie(int movieId) throws MovieNotFoundException;
    Map viewReviews(int movieId) throws MovieNotFoundException, ReviewNotAddedException;
}
