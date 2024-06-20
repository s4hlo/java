package exception;

public class InvalidRentalReturnDateException extends RuntimeException {
    public InvalidRentalReturnDateException(String message) {
        super(message);
    }
}
