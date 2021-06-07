package bean;

import javax.persistence.*;

@Entity
public class Review {

    @Id @GeneratedValue
    int reviewId;

    @ManyToOne
    private User user;

    private int rating;

    @ManyToOne
    private Movie movie;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Review(User user, int rating, Movie movie) {
        this.user = user;
        this.rating = rating;
        this.movie = movie;
    }

    public Review(){}

    @Override
    public String toString() {
        return "Review{" +
                "user=" + user +
                ", rating=" + rating +
                ", movie=" + movie +
                '}';
    }
}
