package vvu.trainning.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Position {

    @Getter @Setter
    private Long latitude;

    @Getter @Setter
    private Long longitude;

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if ((!(obj instanceof Position))) return false;

        return Objects.equals(this.latitude, ((Position)obj).latitude) &&
                Objects.equals(this.longitude, ((Position)obj).longitude);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Position position = new Position();

        position.latitude = this.latitude;
        position.longitude = this.longitude;

        return position;
    }

    @Override
    public String toString() {
        return String.format("%d:%d", latitude, longitude);
    }
}

