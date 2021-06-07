package dao;

import bean.Movie;
import bean.Review;
import bean.User;
import constants.Genre;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MovieRepository {
    List<Movie> movies = new ArrayList<Movie>();
    Map<String, Movie> movieMap = new HashMap<>();



    public Movie getMovie(String movieName) {
        return movieMap.get(movieName);
    }

    public void addMovie(String name, List<Genre> genres, Date releaseDate) {
        Set<Genre> genreSet =  genres.stream().collect(Collectors.toSet());
        Movie movie = new Movie(name, releaseDate, genreSet);
        movieMap.put(name, movie);
        movies.add(movie);
    }

//    public void addReview(User user, Movie movie, int rating) {
//        Review review = new Review(user,rating,movie);
//        movie.postReview(user.getName(), review);
//    }
//
//    public void updateReview(User user, Movie movie, int rating) {
//        Review review = new Review(user,rating,movie);
//        movie.postReview(user.getName(), review);
//    }
//
//    public void deleteReview(User user, Movie movie) {
//        movie.deleteReview(user.getName());
//    }

//    public List<Movie> getTopMovies() {
//        List<Pair<Movie, Double>> moviesRating = new ArrayList<Pair<Movie, Double>>();
//        List<Movie> topMovies = new ArrayList<Movie>();
//        movies.forEach( movie -> {
//            Double rating =  movie.computeRating();
//            Pair<Movie, Double> movieRating = new Pair<Movie, Double>(movie, rating);
//            moviesRating.add(movieRating);
//        });
//
//        Collections.sort(moviesRating, new Comparator<Pair<Movie, Double>>() {
//            @Override
//            public int compare(Pair<Movie, Double> o1, Pair<Movie, Double> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//
//        moviesRating.forEach(movieDoublePair -> {
//            topMovies.add(movieDoublePair.getKey());
//        });
//        return topMovies;
//    }
}