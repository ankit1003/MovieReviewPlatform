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
//        review = ((Review)entityManager.find(Review.class,review));
//        User user = ((Review) entityManager.find(Review.class,review)).getUser();
//        review.getMovie().addReview(review);
//        review.getUser().addReview(review);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
