package service;

import bean.Review;
import dao.ReviewDao;

public class ReviewOperation {

    ReviewDao reviewDao = new ReviewDao();
    public void postReview(Review review){
        reviewDao.postReview(review);
    }
}
