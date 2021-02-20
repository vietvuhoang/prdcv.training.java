package vvu.trainning.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Person {

    @Getter @Setter
    private String name;

    public Person(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
