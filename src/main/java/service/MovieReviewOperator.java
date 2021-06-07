package service;

import bean.Movie;
import dao.MovieRepository;
import bean.User;
import dao.UserRepository;
import constants.Genre;

import java.util.*;

public class MovieReviewOperator {
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MovieReviewOperator() {
        this.movieRepository = new MovieRepository();
        this.userRepository = new UserRepository();
    }

    public void addUser(String name) {
        userRepository.addUser(name);
    }

    public void addMovie(String name, Date releaseDate, List<String> generes) {
        List<Genre> genreList = new ArrayList<>();
        generes.forEach(genere -> {
            genreList.add(Genre.valueOf(genere));
        });
        movieRepository.addMovie(name, genreList, releaseDate);
    }

//    public void addReview(String userName, String movieName, int rating) {
//        User user = userRepository.getUser(userName);
//        if(!userRepository.hasUserGivenReview(user, movieName)) {
//            Movie movie = movieRepository.getMovie(movieName);
//            userRepository.addReview(user, movie, rating);
//            movieRepository.addReview(user, movie, rating);
//        } else {
//            //throws UserAlreadyGivenReviewException
//        }
//    }
//
//    public void updateReview(String userName, String movieName, int rating) {
//        User user = userRepository.getUser(userName);
//        Movie movie = movieRepository.getMovie(movieName);
//        if(userRepository.hasUserGivenReview(user, movieName)) {
//            userRepository.updateReview(user, movie, rating);
//            movieRepository.updateReview(user, movie, rating);
//        } else {
//            //CannotUpdateAsReviewNotPresentException
//        }
//    }
//
//    public void deleteReview(String userName, String movieName) {
//        User user = userRepository.getUser(userName);
//        Movie movie = movieRepository.getMovie(movieName);
//        if(userRepository.hasUserGivenReview(user, movieName)) {
//            userRepository.deleteReview(user, movie);
//            movieRepository.deleteReview(user, movie);
//        } else {
//            //ReviewNotPresentException
//        }
//    }
//
//    public void displayReviewsByUser(String username) {
//        User user = userRepository.getUser(username);
//        userRepository.getReviewsForUser(user).forEach(review -> {
//            System.out.println(review);
//        });
//    }
//
//    public void displayTopNMovies(int N) {
//        movieRepository.getTopMovies().subList(0, N -1).forEach(movie -> {
//            System.out.println(movie.getName());
//        });
//    }
//
//    public void getTopNMoviesOfGenre(Genre genre) {
//        movieRepository.getTopMovies().forEach(movie -> {
//            if(movie.getGenres().contains(genre)) {
//                System.out.println(movie.getName());
//            }
//        });
//    }
//
//    public void getTopNMoviesOfYear(int year) {
//        movieRepository.getTopMovies().forEach(movie -> {
//            if(movie.getReleaseYear().getYear() == year) {
//                System.out.println(movie.getName());
//            }
//        });
//    }


}
