package service;

import exception.ReviewNotFoundException;
import model.Review;

public interface ReviewOperationInterface {
    void postReview(Review review);
    int viewReview(int userId,int movieId) throws ReviewNotFoundException;
    void deleteReview(int reviewId) throws ReviewNotFoundException;
}
