package bean;

import constants.Genre;
import constants.ViewerCategory;

import javax.persistence.*;
import java.util.*;

@Entity
public class Movie {

    @Id
    private String name;

    private Date releaseYear;

    @OneToMany //(cascade = CascadeType.ALL)
    private Set<Review> reviewsSet = new HashSet<Review>();


    @ElementCollection(targetClass = Genre.class)
    private Set<Genre> genres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Set<Review> getReviewsSet() {
        return reviewsSet;
    }

    public void setReviewsSet(Set<Review> reviewsSet) {
        this.reviewsSet = reviewsSet;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Movie(String name, Date releaseYear, Set<Genre> genres) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.reviewsSet = new HashSet<Review>();
        this.genres = genres;
    }
    public Movie(){

    }
    public void addReview(Review review) {
        reviewsSet.add(review);
    }

//    public void deleteReview(String userName) {
//        reviewsMap.remove(userName);
//    }
//
//    public double computeRating() {
//        List<Review> reviewList = new ArrayList<>( reviewsMap.values());
//        double totalReviewCount = 0;
//        double totalReview = 0;
//        for(int i = 0; i < reviewList.size(); i++) {
//            Review review = reviewList.get(i);
//            if(review.getUser().getViewerCategory() == ViewerCategory.CRITIC) {
//                totalReviewCount = totalReviewCount + 2;
//                totalReview = totalReview + (2* review.getRating());
//            } else {
//                totalReviewCount++;
//                totalReview = totalReview + review.getRating();
//            }
//
//        }
//        return totalReview/ totalReviewCount;
//    }
}