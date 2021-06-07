package dao;

import exception.MovieNotFoundException;
import exception.UserNotFoundException;
import model.Movie;
import model.Review;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDao implements MovieDaoInterface{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
    private ReviewDaoInterface reviewDao = new ReviewDao();

    public void addMovie(Movie movie){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void postReview(Review review){
        reviewDao.postReview(review);
    }

    @Override
    public void deleteReview(Review review) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Movie");

    }

    @Override
    public List viewMovies(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select movieId,name from Movie");
        List movies = query.getResultList();
        return movies;
    }

    @Override
    public Movie viewMovie(int movieId) throws MovieNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Movie movie = (Movie) entityManager.find(Movie.class,movieId);
        if(movie==null)
            throw new MovieNotFoundException(movieId);
        else{
            return movie;
        }
    }


    public Map viewReviews(int movieId) throws MovieNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Movie movie = entityManager.find(Movie.class,movieId);
        if(movie==null)
            throw new MovieNotFoundException(movieId);
        else{
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for (Review review: movie.getReviewsSet()){
                map.put(review.getUser().getUserId(), review.getRating());
            }
            return map;
        }
    }


}
