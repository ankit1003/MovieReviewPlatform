package dao;

import exception.ReviewNotFoundException;
import model.Movie;
import model.Review;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReviewDao implements ReviewDaoInterface{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");

    public void postReview(Review review){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(review);
        User user = (User) entityManager.find(User.class,review.getUser().getUserId());
        Movie movie = (Movie) entityManager.find(Movie.class, review.getMovie().getMovieId());
        movie.addReview(review);
        user.addReview(review);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public int viewReview(int userId, int movieId) throws ReviewNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Movie movie = entityManager.find(Movie.class,movieId);
//        Review review = null;
        for (Review review:movie.getReviewsSet() ){
            if(review.getUser().getUserId()==userId){
                return review.getRating();
            }
        }
        throw new ReviewNotFoundException();
    }

    @Override
    public void deleteReview(int reviewId) throws ReviewNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Review review = entityManager.find(Review.class,reviewId);
        if(review==null){
            throw new ReviewNotFoundException(reviewId);
        }
        User user = entityManager.find(User.class,review.getUser().getUserId());
        Movie movie = entityManager.find(Movie.class,review.getMovie().getMovieId());
        movie.deleteReview(review);
        user.deleteReview(review);
        entityManager.remove(review);
        entityManager.getTransaction().commit();
    }


}
