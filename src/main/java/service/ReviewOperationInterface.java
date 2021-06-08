package service;

import exception.MovieNotFoundException;
import exception.ReviewNotFoundException;
import exception.UserNotFoundException;
import model.Review;

public interface ReviewOperationInterface {
    void postReview(Review review) throws UserNotFoundException, MovieNotFoundException;
    int viewReview(int userId,int movieId) throws ReviewNotFoundException, UserNotFoundException, MovieNotFoundException;
    void deleteReview(int reviewId) throws ReviewNotFoundException;
}
