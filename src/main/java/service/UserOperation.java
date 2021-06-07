package service;

import bean.Review;
import bean.User;
import dao.UserDao;

public class UserOperation {
    UserDao userDao = new UserDao();
    public void addUser(User user){
        userDao.addUser(user);
    }
    public void postReview(Review review) {
        userDao.postReview(review);
    }
}
