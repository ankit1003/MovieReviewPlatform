package dao;

import bean.Movie;
import bean.Review;
import bean.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieDao {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
    private ReviewDao reviewDao = new ReviewDao();

    public void addMovie(Movie movie){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
    }

    public void postReview(Review review){
        reviewDao.postReview(review);
    }
}
