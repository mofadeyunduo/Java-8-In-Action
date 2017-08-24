package ch05.practice;

import ch04.dataGenerator.DishFactory;
import ch04.model.Dish;

import java.util.Arrays;
import java.util.List;

import static ch05.tool.PrintTool.print;
import static java.util.stream.Collectors.toList;

public class MapPractice {

    private List<Dish> menu;
    private List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");

    public MapPractice(List<Dish> menu) {
        this.menu = menu;
    }

    public void map() {
        print(
                menu.stream()
                        .map(Dish::getName)
                        .collect(toList())
        );
    }

    public void selectDishNameSize() {
        print(
                words.stream()
                        .map(String::length)
                        .collect(toList())
        );
    }

    public void flatMap() {
        print(
                words.stream()
                        .map(word -> word.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(toList())
        );
    }

    public void numberSquare() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        print(
                numbers.stream()
                        .map(n -> n * n)
                        .collect(toList())
        );
    }

    public void twoArrayElementsPair() {
        List<Integer> leftPair = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> rightPair = Arrays.asList(6, 7, 8, 9, 10);

        List<int[]> pairs = leftPair.stream()
                .flatMap(i -> rightPair.stream().map(j -> new int[]{i, j}))
                .collect(toList());

        pairs.forEach(pair -> System.out.println(pair[0] + " " + pair[1]));
    }

    public static void main(String[] args) {
        MapPractice practice = new MapPractice(DishFactory.createDishesExample());

        practice.map();
        practice.selectDishNameSize();
        practice.flatMap();
        practice.numberSquare();
        practice.twoArrayElementsPair();
    }

}
