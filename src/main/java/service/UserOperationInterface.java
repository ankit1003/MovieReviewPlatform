package service;

import model.Review;
import model.User;

public interface UserOperationInterface {
    public void addUser(User user);
    public void postReview(Review review);
}
