package vvu.trainning.practice2.notification;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import vvu.trainning.common.Member;
import vvu.trainning.exception.ValidationError;

import static org.junit.Assert.*;

public class EmailNotifierTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNotify_validEmail_done() throws ValidationError {
        Member member = new Member("Vu Hoang Viet");
        member.setEmail("vietvuhoang@gmail.com");
        member.setPhone("+864912784821");

        EmailNotifier notifier = new EmailNotifier();

        notifier.notify( member, "HelloWorld");
    }

    @Test(expected = ValidationError.class)
    public void testNotify_invalidEmail_ValidationError() throws ValidationError {
        Member member = new Member("Vu Hoang Viet");
        member.setPhone("+864912784821");

        EmailNotifier notifier = new EmailNotifier();

        notifier.notify( member, "HelloWorld");
    }
}