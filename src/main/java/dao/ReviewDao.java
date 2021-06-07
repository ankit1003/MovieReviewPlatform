package dao;

import bean.Movie;
import bean.Review;
import bean.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReviewDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");

    public void postReview(Review review){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(review);
//        review.getMovie().addReview(review);
//        review.getUser().addReview(review);
//        review =(Review) entityManager.find(Review.class,review.getReviewId());
        User user = (User) entityManager.find(User.class,review.getUser().getName());
        Movie movie = (Movie) entityManager.find(Movie.class, review.getMovie().getName());
//        Movie movie = review.getMovie();
        movie.addReview(review);
        user.addReview(review);
//        entityManager.merge(movie);
//        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
