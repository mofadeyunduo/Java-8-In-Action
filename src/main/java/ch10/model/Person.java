package ch10.model;

import java.util.Optional;

public class Person {

    private Optional<Car> car;
    private int minAge;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

}
