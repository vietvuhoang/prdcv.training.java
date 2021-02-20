package vvu.trainning.common;

import org.junit.Assert;
import org.junit.Test;

public class MemberTest {

    public void setUp() {
    }

    public void tearDown() {
    }

    @Test
    public void testToString() {

        Member member = new Member("Vu Hoang Viet");
        member.setEmail("vietvuhoang@gmail.com");
        member.setPhone("+864912784821");

        String testS = "Member{" +
                "name='" + member.getName() + '\'' +
                ", email='" + member.getEmail() + '\'' +
                ", phone='" + member.getPhone() + '\'' +
                '}';

        Assert.assertEquals(testS, member.toString());
    }
}