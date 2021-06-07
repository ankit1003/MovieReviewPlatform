package service;

import dao.MovieDaoInterface;
import model.Movie;
import model.Review;
import dao.MovieDao;

public class MovieOperation  implements MovieOperationInterface{
    MovieDaoInterface movieDao = new MovieDao();

    public  void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    public void postReview(Review review) {
        movieDao.postReview(review);
    }

}
