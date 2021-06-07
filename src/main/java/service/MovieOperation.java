package service;

import bean.Movie;
import bean.Review;
import dao.MovieDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieOperation {
    MovieDao movieDao = new MovieDao();

    public  void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    public void postReview(Review review) {
        movieDao.postReview(review);
    }

}
