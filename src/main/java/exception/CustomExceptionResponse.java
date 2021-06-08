package exception;


import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlRootElement;


@Provider
public class CustomExceptionResponse {
    private int code;
    private String message;
    private String errorDetails;

    public CustomExceptionResponse(int code, String message, String errorDetails) {
        this.code = code;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public CustomExceptionResponse(){
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
}
