package service;

import exception.UserNotFoundException;
import model.Review;
import model.User;

import java.util.List;
import java.util.Map;

public interface UserOperationInterface {
    void addUser(User user);
    void postReview(Review review);
    List viewUsers();
    User viewUser(int userId) throws UserNotFoundException;
    Map viewReviews(int userId) throws UserNotFoundException;
}
