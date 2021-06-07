package dao;

import model.Movie;
import model.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieDao implements MovieDaoInterface{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
    private ReviewDaoInterface reviewDao = new ReviewDao();

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
