package bean;

import constants.ViewerCategory;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class User {

    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private  ViewerCategory viewerCategory;

    @OneToMany //(cascade = CascadeType.ALL)
    private Set<Review> reviewsSet = new HashSet<Review>();

    private int numberOfReview;

    private final int minNumReviewsRequiredForCritic = 4;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ViewerCategory getViewerCategory() {
        return viewerCategory;
    }

    public void setViewerCategory(ViewerCategory viewerCategory) {
        this.viewerCategory = viewerCategory;
    }

    public Set<Review> getReviewsSet() {
        return reviewsSet;
    }

    public void setReviewsMap(Set<Review> reviewsSet) {
        this.reviewsSet = reviewsSet;
    }

    public int getNumberOfReview() {
        return numberOfReview;
    }

    public void setNumberOfReview(int numberOfReview) {
        this.numberOfReview = numberOfReview;
    }


    public User(String name) {
        this.name = name;
        this.viewerCategory = ViewerCategory.VIEWER;
        numberOfReview = 0;
        this.reviewsSet = reviewsSet;
    }

    public User(){

    }
    public void addReview(Review review) {
        reviewsSet.add(review);
        numberOfReview++;
        if(numberOfReview >= minNumReviewsRequiredForCritic) {
            this.viewerCategory = ViewerCategory.CRITIC;
        }
    }
//
//    public void deleteReview(String name) {
//        reviewsMap.remove(name);
//        numberOfReview--;
//        if(numberOfReview < minNumReviewsRequiredForCritic) {
//            this.viewerCategory = ViewerCategory.VIEWER;
//        }
//    }
}


