package vvu.trainning.practice1.transport;

import vvu.trainning.common.Position;
import vvu.trainning.exception.ApplicationError;

import java.util.Objects;

public abstract class Vehicle implements Movable {

    private String licensePlate;

    public String getLicensePlate() {
        return licensePlate;
    }

    public Vehicle(String licensePlate) {
        this.licensePlate = Objects.requireNonNull(licensePlate);
    }

    public abstract void moveTo(Position pos) throws ApplicationError;
}
