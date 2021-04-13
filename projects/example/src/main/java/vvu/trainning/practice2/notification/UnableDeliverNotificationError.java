package vvu.trainning.practice2.notification;

import vvu.trainning.exception.ApplicationError;

public class UnableDeliverNotificationError extends ApplicationError {
    public UnableDeliverNotificationError() {
        super();
    }

    public UnableDeliverNotificationError(Throwable e) {
        super(e);
    }

    public UnableDeliverNotificationError(String message ) {
        super(message);
    }
}
