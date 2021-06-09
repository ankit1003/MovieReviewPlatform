package response;

import constants.ViewerCategory;

public class UserResponse {
    private String name;
    private ViewerCategory viewerCategory;
    private int numberOfReviews;

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

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }
}
