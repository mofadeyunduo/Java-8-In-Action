package ch10.practice;

import ch10.model.Car;
import ch10.model.Insurance;
import ch10.model.Person;

import java.util.Optional;

public class OptionalPractice {

    public String getCarInsuranceName(Person person) {
        Optional<Person> optionalPerson = Optional.ofNullable(person);

        return optionalPerson
                .filter(p -> p.getMinAge() >= 20)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }

    public static void main(String[] args) {
        OptionalPractice practice = new OptionalPractice();

        Person personWithNoCar = new Person();
        personWithNoCar.setCar(Optional.empty());
        personWithNoCar.setMinAge(20);
        System.out.println(practice.getCarInsuranceName(personWithNoCar));
        System.out.println();

        Insurance insurance = new Insurance();
        insurance.setName("insurance");
        Car car = new Car();
        car.setInsurance(Optional.of(insurance));
        Person personWithCar = new Person();
        personWithCar.setCar(Optional.of(car));
        personWithCar.setMinAge(20);
        System.out.println(practice.getCarInsuranceName(personWithCar));
        System.out.println();
    }

}
