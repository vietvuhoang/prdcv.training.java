package vvu.trainning.common.things;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Goods {

    @Getter
    private final String id = UUID.randomUUID().toString();

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
