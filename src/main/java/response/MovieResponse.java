package response;

import constants.Genre;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class MovieResponse {
    private String name;
//    private Date releaseYear;
    private Set<Genre> genres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Date getReleaseYear() {
//        return releaseYear;
//    }
//
//    public void setReleaseYear(Date releaseYear) {
//        this.releaseYear = releaseYear;
//    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
