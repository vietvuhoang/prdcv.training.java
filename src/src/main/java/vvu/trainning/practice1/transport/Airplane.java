package vvu.trainning.practice1.transport;

import vvu.trainning.common.Person;
import vvu.trainning.common.Position;
import vvu.trainning.common.things.Goods;
import vvu.trainning.exception.ApplicationError;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Airplane implements Movable {

    private String id;
    private Person pilot;
    private String flightNumber;
    private List<Goods> goodsList = new LinkedList<>();
    private List<Person> passengers = new LinkedList<>();

    public Airplane(String id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public void moveTo(Position pos) throws ApplicationError {
        if (pos == null) throw new ApplicationError("Moving Position is required");

        if (pilot == null) throw new ApplicationError("Driver is required");
        if (flightNumber == null) throw new ApplicationError("Flight Number is required");

        System.out.println("Airplane ID " +  id);
        System.out.println("Flight Number " +  flightNumber);
        System.out.println("Pilot " +  pilot.toString());

        if (passengers.isEmpty()) {
            System.out.println("No Goods on Container");
        } else {
            System.out.println("Passengers : " + passengers.stream().map(Person::toString).collect(Collectors.toList()));
        }

        if (goodsList.isEmpty()) {
            System.out.println("No Goods on Container");
        } else {
            System.out.println("Goods : " + goodsList.stream().map(Goods::toString).collect(Collectors.toList()));
        }

        System.out.println("Move To : " + pos.toString());
    }

    public void assignPilot(Person pilot) {
        this.pilot = Objects.requireNonNull(pilot);
    }

    public void assignFlightNumber(String flightNumber) {
        this.flightNumber = Objects.requireNonNull(flightNumber);;
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    public void addPassengers(Person person) {
        passengers.add(person);
    }
}
