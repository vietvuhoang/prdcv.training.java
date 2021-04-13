package vvu.trainning.practice1.transport;

import vvu.trainning.common.Person;
import vvu.trainning.common.Position;
import vvu.trainning.exception.ApplicationError;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Car extends Vehicle {

    private List<Person> passengers = new LinkedList<>();

    public Car(String licensePlate) {
        super(licensePlate);
    }

    public void add(Person person) {
        passengers.add(person);
    }

    @Override
    public void moveTo(Position pos) throws ApplicationError {
        if (pos == null) throw new ApplicationError("Moving Position is required");
        if (passengers.isEmpty()) throw new ApplicationError("There is No passenger in CAR");

        System.out.println("CAR License Plate : " + this.getLicensePlate());
        System.out.println("Passengers : " + passengers.stream().map(Person::toString).collect(Collectors.toList()));
        System.out.println("Move To : " + pos.toString());
    }
}
