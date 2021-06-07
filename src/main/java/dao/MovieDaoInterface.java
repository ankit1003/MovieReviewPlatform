package dao;

import model.Movie;
import model.Review;

public interface MovieDaoInterface {
    void addMovie(Movie movie);
    void postReview(Review review);
}
