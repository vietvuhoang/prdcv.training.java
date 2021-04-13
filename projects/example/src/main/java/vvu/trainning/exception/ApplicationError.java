package vvu.trainning.exception;

public class ApplicationError extends Exception {
    public ApplicationError() {
        super();
    }

    public ApplicationError(Throwable e) {
        super(e);
    }

    public ApplicationError(String message ) {
        super(message);
    }
}
