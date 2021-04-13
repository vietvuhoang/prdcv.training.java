package vvu.trainning.practice2.notification;

import org.apache.commons.lang3.StringUtils;
import vvu.trainning.common.Member;
import vvu.trainning.exception.ValidationError;

public class EmailNotifier implements INotifier {
    @Override
    public void notify(Member member, String message) throws ValidationError {
        if (StringUtils.isEmpty( member.getEmail())) throw new ValidationError("Unable to deliver Email Notification");
        System.out.println("Send Email to " + member.getEmail() + ". Message: " + message );
    }
}
