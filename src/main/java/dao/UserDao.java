package dao;

import exception.UserNotFoundException;
import model.Review;
import model.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.annotation.Native;
import java.util.*;

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


    public List viewUsers(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select userId,name from User");
        List users = query.getResultList();
        entityManager.close();
        return users;
    }

    public User viewUser(int userId) throws UserNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = (User) entityManager.find(User.class,userId);
        if(user==null)
            throw new UserNotFoundException(userId);
        else{
            return user;
        }
    }


    public Map viewReviews(int userId) throws UserNotFoundException{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,userId);
        if(user==null)
            throw new UserNotFoundException(userId);
        else{
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for (Review review: user.getReviewsSet()){
                map.put(review.getMovie().getMovieId(), review.getRating());
            }
            return map;
        }
    }





}
