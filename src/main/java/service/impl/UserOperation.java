package service.impl;

import dto.UserDaoInterface;
import exception.UserNotFoundException;
import model.Review;
import model.User;
import dto.impl.UserDao;
import service.UserOperationInterface;

import java.util.List;
import java.util.Map;

public class UserOperation implements UserOperationInterface {
    UserDaoInterface userDao = new UserDao();

    @Override
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Override
    public void postReview(Review review) {
        userDao.postReview(review);
    }

    @Override
    public List viewUsers() {
        return userDao.viewUsers();
    }

    @Override
    public User viewUser(int userId) throws UserNotFoundException {
        return userDao.viewUser(userId);
    }

    @Override
    public Map viewReviews(int userId) throws UserNotFoundException {
        return userDao.viewReviews(userId);
    }


}
