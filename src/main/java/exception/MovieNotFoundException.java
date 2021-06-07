package exception;

public class MovieNotFoundException extends Exception{
    private int movieId;

    public MovieNotFoundException(int movieId){
        this.movieId = movieId;
    }

    public int getMovieId(){
        return movieId;
    }

    public String getMessage(){
        return "Movie with movieId " + movieId + " not found";
    }
}
