package vvu.trainning.exception;

public class ValidationError extends ApplicationError {
    public ValidationError() {
        super();
    }

    public ValidationError(Throwable e) {
        super(e);
    }

    public ValidationError(String message ) {
        super(message);
    }
}
