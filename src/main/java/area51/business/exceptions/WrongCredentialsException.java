package area51.business.exceptions;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException() {
        super();
    }

    public WrongCredentialsException(String message) {
        super(message);
    }
}