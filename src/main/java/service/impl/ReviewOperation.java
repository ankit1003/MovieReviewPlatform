package service.impl;

import dto.ReviewDaoInterface;
import exception.MovieNotFoundException;
import exception.ReviewNotFoundException;
import exception.UserNotFoundException;
import model.Review;
import dto.impl.ReviewDao;
import service.ReviewOperationInterface;

public class ReviewOperation implements ReviewOperationInterface {

    ReviewDaoInterface reviewDao = new ReviewDao();

    @Override
    public void postReview(Review review) throws UserNotFoundException, MovieNotFoundException {

        reviewDao.postReview(review);
    }

    @Override
    public Review viewReview(int userId, int movieId) throws ReviewNotFoundException, UserNotFoundException, MovieNotFoundException {
        return reviewDao.viewReview(userId,movieId);
    }

    @Override
    public void deleteReview(int reviewId) throws ReviewNotFoundException {
        reviewDao.deleteReview(reviewId);
    }
}
