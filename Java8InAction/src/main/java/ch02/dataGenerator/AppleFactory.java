package ch02.dataGenerator;

import ch02.model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleFactory {

    private final static AppleFactory appleFactory = new AppleFactory();

    private AppleFactory() {
    }

    public static List<Apple> createApplesExample() {
        Apple apple1 = new Apple(20, "GREEN");
        Apple apple2 = new Apple(30, "RED");
        Apple apple3 = new Apple(30, "GREEN");
        Apple apple4 = new Apple(50, "PURPLE");

        List<Apple> apples = new ArrayList<>();
        apples.addAll(Arrays.asList(apple1, apple2, apple3, apple4));
        return apples;
    }

}
