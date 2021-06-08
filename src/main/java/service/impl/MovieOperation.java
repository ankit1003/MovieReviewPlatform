package service.impl;

import dto.MovieDaoInterface;
import exception.MovieNotFoundException;
import model.Movie;
import model.Review;
import dto.impl.MovieDao;
import service.MovieOperationInterface;

import java.util.List;
import java.util.Map;

public class MovieOperation  implements MovieOperationInterface {
    MovieDaoInterface movieDao = new MovieDao();

    @Override
    public  void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    @Override
    public void postReview(Review review) {
        movieDao.postReview(review);
    }

    @Override
    public void deleteReview(Review review) {
        movieDao.deleteReview(review);
    }

    @Override
    public List viewMovies() {
        return movieDao.viewMovies();
    }

    @Override
    public Movie viewMovie(int movieId) throws MovieNotFoundException {
        return movieDao.viewMovie(movieId);
    }

    @Override
    public Map viewReviews(int movieId) throws MovieNotFoundException {
        return movieDao.viewReviews(movieId);
    }


}
