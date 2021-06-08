package exception;

public class CustomExceptionResponse {
    private int code;
    private String message;
    private String errorDetails;

    public CustomExceptionResponse(int code, String message, String errorDetails) {
        this.code = code;
        this.message = message;
        this.errorDetails = errorDetails;
    }
}
