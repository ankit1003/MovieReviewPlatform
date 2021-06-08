package dto.impl;

import dto.ReviewDaoInterface;
import exception.MovieNotFoundException;
import exception.ReviewNotFoundException;
import exception.UserNotFoundException;
import model.Movie;
import model.Review;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReviewDao implements ReviewDaoInterface {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");

    public void postReview(Review review) throws UserNotFoundException, MovieNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(review);
        User user = (User) entityManager.find(User.class,review.getUser().getUserId());
        Movie movie = (Movie) entityManager.find(Movie.class, review.getMovie().getMovieId());
        if(user==null)
            throw new UserNotFoundException();
        if(movie==null)
            throw new MovieNotFoundException() ;
        movie.addReview(review);
        user.addReview(review);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public int viewReview(int userId, int movieId) throws ReviewNotFoundException, MovieNotFoundException, UserNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Movie movie = entityManager.find(Movie.class,movieId);
//        Review review = null;
        if(movie==null){
            throw new MovieNotFoundException();
        }
        User user = entityManager.find(User.class,userId);
        if(user==null){
            throw new UserNotFoundException();
        }
        for(Review review : movie.getReviewsSet()){
            if(review.getUser()==user)
                return review.getRating();
        }
        throw new ReviewNotFoundException();
    }

    @Override
    public void deleteReview(int reviewId) throws ReviewNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Review review = entityManager.find(Review.class,reviewId);
        if(review==null){
            throw new ReviewNotFoundException();
        }
        User user = entityManager.find(User.class,review.getUser().getUserId());
        Movie movie = entityManager.find(Movie.class,review.getMovie().getMovieId());
        movie.deleteReview(review);
        user.deleteReview(review);
        entityManager.remove(review);
        entityManager.getTransaction().commit();
    }


}
