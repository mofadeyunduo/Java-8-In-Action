package ch02.practice;

import ch02.dataGenerator.AppleFactory;
import ch02.model.Apple;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class FilterApple {

    public List<Apple> filterApple(List<Apple> apples, Predicate<Apple> predicate) {
        return apples.stream()
                .filter(predicate)
                .collect(toList());
    }

    public static void main(String[] args) {
        List<Apple> apples = AppleFactory.createApplesExample();

        FilterApple filterApple = new FilterApple();
        filterApple.filterApple(apples, apple -> apple.getColor().equals("GREEN")).forEach(System.out::println);
        System.out.println();

        filterApple.filterApple(apples, apple -> apple.getWeight() >= 30).forEach(System.out::println);
        System.out.println();

        // 比较器复合
        apples.sort(
                Comparator
                        .comparingInt(Apple::getWeight)
                        .reversed()
                        .thenComparing(
                                Comparator
                                        .comparing(Apple::getColor)
                        )
        );
        apples.forEach(System.out::println);
        System.out.println();

        // 谓词复合
        Predicate<Apple> green = apple -> apple.getColor().equals("GREEN");
        Predicate<Apple> greenAndGE20 = green.and(apple -> apple.getWeight() >= 25);
        filterApple.filterApple(apples, greenAndGE20).forEach(System.out::println);
        System.out.println();

        // 函数复合
        Function<String, Integer> nameToLength = String::length;
        Function<Integer, String> integerToString = String::valueOf;
        apples.forEach(apple -> System.out.println(nameToLength.andThen(integerToString).apply(apple.getColor())));
        System.out.println();
    }

}
