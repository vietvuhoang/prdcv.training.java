package vvu.trainning.practice2.notification;

import org.apache.commons.lang3.StringUtils;
import vvu.trainning.common.Member;
import vvu.trainning.exception.ApplicationError;
import vvu.trainning.exception.ValidationError;

import java.util.List;
import java.util.Objects;

public class NotificationCenter {

    private final INotifier notifier;

    public NotificationCenter(INotifier notifier) {
        this.notifier = Objects.requireNonNull(notifier);
    }

    public void publishNotification(List<Member> members, String message ) throws ApplicationError {

        if (StringUtils.isEmpty(message)) return;

        for (Member member: members ) {
            try {
                notifier.notify(member, message);
            } catch (ValidationError e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
