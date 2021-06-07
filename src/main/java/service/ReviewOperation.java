package service;

import dao.ReviewDaoInterface;
import exception.ReviewNotFoundException;
import model.Review;
import dao.ReviewDao;

public class ReviewOperation implements ReviewOperationInterface{

    ReviewDaoInterface reviewDao = new ReviewDao();

    @Override
    public void postReview(Review review){

        reviewDao.postReview(review);
    }

    @Override
    public int viewReview(int userId, int movieId) throws ReviewNotFoundException {
        return reviewDao.viewReview(userId,movieId);
    }

    @Override
    public void deleteReview(int reviewId) throws ReviewNotFoundException {
        reviewDao.deleteReview(reviewId);
    }
}
