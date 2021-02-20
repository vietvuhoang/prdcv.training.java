package vvu.trainning.practice2.notification;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import vvu.trainning.common.Member;
import vvu.trainning.exception.ApplicationError;
import vvu.trainning.exception.ValidationError;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NotificationCenterTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void testNotificationCenter_invalidNotifier_NullPointerException() {
        new NotificationCenter( null );
    }

    @Test
    public void publishNotification_validMemberList_NotifyAll() throws ApplicationError {

        /// PREPARE DATA
        Member member1 = new Member("Vu Hoang Viet");
        member1.setEmail("vietvuhoang@gmail.com");
        member1.setPhone("+84912784821");

        Member member2 = new Member("Nguyen Van Khang");
        member2.setEmail("nguyenvankhang@gmail.com");
        member2.setPhone("+84983710870");

        List<Member> memberList = Arrays.asList(member1, member2);

        String message = "Hello Mockito";

        // MOCKING OBJECT

        INotifier notifier = Mockito.mock(INotifier.class);

        // EXECUTE THE TEST

        NotificationCenter notificationCenter = new NotificationCenter(notifier);

        notificationCenter.publishNotification(memberList, message);

        // Validate the Result

        ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass( Member.class );
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass( String.class );

        Mockito.verify( notifier, Mockito.times( memberList.size())).notify( memberArgumentCaptor.capture(), stringArgumentCaptor.capture());

        for (int i = 0; i < memberList.size(); i++ ) {
            assertEquals( message, stringArgumentCaptor.getAllValues().get(i));
            assertEquals( memberList.get(i).toString(), memberArgumentCaptor.getAllValues().get(i).toString());
        }
    }

    @Test
    public void publishNotification_MemberValidationError_NoError() throws ApplicationError {
        /// PREPARE DATA
        Member member1 = new Member("Vu Hoang Viet");
        member1.setEmail("vietvuhoang@gmail.com");
        member1.setPhone("+84912784821");

        Member member2 = new Member("Nguyen Van Khang");
        member2.setEmail("nguyenvankhang@gmail.com");
        member2.setPhone("+84983710870");

        List<Member> memberList = Arrays.asList(member1, member2);

        String message = "Hello Mockito";

        // MOCKING OBJECT

        INotifier notifier = Mockito.mock(INotifier.class);

        Mockito.doNothing().when(notifier).notify(member1, message);
        Mockito.doThrow(new ValidationError("Validation Message")).when(notifier).notify(member2, message);

        // EXECUTE THE TEST

        NotificationCenter notificationCenter = new NotificationCenter(notifier);

        notificationCenter.publishNotification(memberList, message);

        // Validate the Result
        ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass( Member.class );
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass( String.class );

        Mockito.verify( notifier, Mockito.times( memberList.size())).notify( memberArgumentCaptor.capture(), stringArgumentCaptor.capture());

        for (int i = 0; i < memberList.size(); i++ ) {
            assertEquals( message, stringArgumentCaptor.getAllValues().get(i));
            assertEquals( memberList.get(i).toString(), memberArgumentCaptor.getAllValues().get(i).toString());
        }
    }

    @Test(expected = UnableDeliverNotificationError.class)
    public void publishNotification_UnableDeliverNotificationError_ExecuteOnceWithError() throws ApplicationError {
        /// PREPARE DATA
        Member member1 = new Member("Vu Hoang Viet");
        member1.setEmail("vietvuhoang@gmail.com");
        member1.setPhone("+84912784821");

        Member member2 = new Member("Nguyen Van Khang");
        member2.setEmail("nguyenvankhang@gmail.com");
        member2.setPhone("+84983710870");

        List<Member> memberList = Arrays.asList(member1, member2);

        String message = "Hello Mockito";

        // MOCKING OBJECT

        INotifier notifier = Mockito.mock(INotifier.class);

        UnableDeliverNotificationError notificationError = new UnableDeliverNotificationError();

        Mockito.doThrow(notificationError).when(notifier).notify(member1, message);

        // EXECUTE THE TEST

        NotificationCenter notificationCenter = new NotificationCenter(notifier);

        try {
            notificationCenter.publishNotification(memberList, message);
            fail();
        } catch (UnableDeliverNotificationError e) {

            assertSame(notificationError, e);
            throw e;

        } finally {
            // Validate the Result
            ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass( Member.class );
            ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass( String.class );

            Mockito.verify( notifier, Mockito.only()).notify( memberArgumentCaptor.capture(), stringArgumentCaptor.capture());

            assertEquals( message, stringArgumentCaptor.getAllValues().get(0));
            assertEquals( memberList.get(0).toString(), memberArgumentCaptor.getAllValues().get(0).toString());
        }
    }
}