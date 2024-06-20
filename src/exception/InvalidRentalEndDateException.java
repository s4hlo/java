package exception;

public class InvalidRentalEndDateException extends RuntimeException {
    public InvalidRentalEndDateException(String message) {
        super(message);
    }
}
