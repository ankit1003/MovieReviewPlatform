package service;

import dao.ReviewDaoInterface;
import model.Review;
import dao.ReviewDao;

public class ReviewOperation implements ReviewOperationInterface{

    ReviewDaoInterface reviewDao = new ReviewDao();
    public void postReview(Review review){
        reviewDao.postReview(review);
    }
}
