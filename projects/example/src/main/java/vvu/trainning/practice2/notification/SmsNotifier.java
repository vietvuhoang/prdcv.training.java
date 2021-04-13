package vvu.trainning.practice2.notification;

import org.apache.commons.lang3.StringUtils;
import vvu.trainning.common.Member;
import vvu.trainning.exception.ValidationError;

public class SmsNotifier implements INotifier {
    @Override
    public void notify(Member member, String message) throws ValidationError  {
        if (StringUtils.isEmpty( member.getPhone())) throw new ValidationError("Unable to deliver SMS Notification");
        System.out.println("Send SMS to " + member.getPhone() + ". Message: " + message );
    }
}
