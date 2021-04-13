package vvu.trainning.practice2.notification;

import vvu.trainning.common.Member;
import vvu.trainning.exception.ApplicationError;
import vvu.trainning.exception.ValidationError;

public interface INotifier {
    void notify(Member member, String message ) throws ValidationError, UnableDeliverNotificationError;
}
