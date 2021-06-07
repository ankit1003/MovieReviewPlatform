package dao;

import bean.Movie;
import bean.Review;
import bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    List<User> users = new ArrayList<User>();
    Map<String, User> userMap = new HashMap<>();



    public void addUser(String name) {
        User user = new User(name);
        users.add(user);
        userMap.put(name, user);
    }

    public User getUser(String userName) {
        return userMap.get(userName);
    }

//    public void addReview(User user, Movie movie, int rating) {
//        Review review = new Review(user,rating,movie);
//        user.postReviewMap(movie.getName(), review);
//    }
//
//    public boolean hasUserGivenReview(User user, String movieName) {
//        return user.getReviewsMap().containsKey(movieName);
//    }
//
//    public void updateReview(User user, Movie movie, int rating) {
//        Review review = new Review(user,rating,movie);
//        user.postReviewMap(movie.getName(), review);
//    }
//
//    public void deleteReview(User user, Movie movie) {
//        user.deleteReview(movie.getName());
//    }
//
//    public List<Review> getReviewsForUser(User user) {
//        return new ArrayList<Review>(user.getReviewsMap().values());
//    }
}
