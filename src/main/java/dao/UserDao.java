package dao;

import model.Review;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDao implements UserDaoInterface{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
    private ReviewDaoInterface reviewDao = new ReviewDao();

    public void addUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void postReview(Review review){
        reviewDao.postReview(review);
    }
}
