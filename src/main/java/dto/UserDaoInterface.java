package dto;

import exception.UserNotFoundException;
import model.Review;
import model.User;

import java.util.List;
import java.util.Map;

public interface UserDaoInterface {
    void addUser(User user);
    void postReview(Review review);
    List viewUsers();
    User viewUser(int userId) throws UserNotFoundException;
    Map viewReviews(int userId) throws UserNotFoundException;
}
