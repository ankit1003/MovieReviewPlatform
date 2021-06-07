package dao;

import model.Review;
import model.User;

public interface UserDaoInterface {
    void addUser(User user);
    void postReview(Review review);
}
