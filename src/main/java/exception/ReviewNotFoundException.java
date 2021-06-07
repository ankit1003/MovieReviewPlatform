package exception;

public class ReviewNotFoundException extends Exception{
    private int reviewId;

    public ReviewNotFoundException(int reviewId) {
        this.reviewId = reviewId;
    }

    public ReviewNotFoundException() {
    }
    public int getReviewId() {
        return reviewId;
    }

    public String getMessage(){
        return "Review with reviewId " + reviewId + " not found.";
    }
}
