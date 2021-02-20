package vvu.trainning.common;

import lombok.Getter;
import lombok.Setter;

public class Member extends Person {

    public Member(String name) {
        super(name);
    }

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String phone;

    @Override
    public String toString() {
        return "Member{" +
                "name='" + this.getName() + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
