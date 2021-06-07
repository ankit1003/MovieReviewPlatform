package service;

import model.Movie;
import model.Review;

public interface MovieOperationInterface {
    void addMovie(Movie movie);
    void postReview(Review review);
}
