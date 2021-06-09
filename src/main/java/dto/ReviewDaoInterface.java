package dto;

import exception.MovieNotFoundException;
import exception.ReviewNotFoundException;
import exception.UserNotFoundException;
import model.Review;

public interface ReviewDaoInterface {
    void postReview(Review review) throws UserNotFoundException, MovieNotFoundException;
    Review viewReview(int userId, int movieId) throws ReviewNotFoundException, MovieNotFoundException, UserNotFoundException;
    void deleteReview(int reviewId) throws ReviewNotFoundException;
}
