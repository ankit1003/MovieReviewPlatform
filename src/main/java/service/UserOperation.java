package service;

import dao.UserDaoInterface;
import model.Review;
import model.User;
import dao.UserDao;

public class UserOperation implements UserOperationInterface{
    UserDaoInterface userDao = new UserDao();
    public void addUser(User user){
        userDao.addUser(user);
    }
    public void postReview(Review review) {
        userDao.postReview(review);
    }
}
