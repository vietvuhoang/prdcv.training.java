package vvu.trainning.practice1.transport;

import vvu.trainning.common.Person;
import vvu.trainning.common.Position;
import vvu.trainning.common.things.Goods;
import vvu.trainning.exception.ApplicationError;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Truck extends Vehicle {

    private List<Goods> goodsList = new LinkedList<>();
    private Person driver;

    public Truck(String licensePlate) {
        super(licensePlate);
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    public void setDriver(Person driver) {
        this.driver = Objects.requireNonNull(driver);
    }

    @Override
    public void moveTo(Position pos) throws ApplicationError {

        if (pos == null) throw new ApplicationError("Moving Position is required");

        if (driver == null) throw new ApplicationError("Driver is required");

        if (goodsList.isEmpty()) {
            System.out.println("No Goods on Container");
        } else {
            System.out.println("Goods : " + goodsList.stream().map(Goods::toString).collect(Collectors.toList()));
        }

        System.out.println("Move To : " + pos.toString());
    }
}
