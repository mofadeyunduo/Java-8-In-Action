package ch05.practice;

import ch04.dataGenerator.DishFactory;
import ch04.model.Dish;

import java.util.Arrays;
import java.util.List;

import static ch05.tool.PrintTool.print;
import static java.util.stream.Collectors.toList;

public class FilterPractice {

    private List<Dish> menu;

    public FilterPractice(List<Dish> menu) {
        this.menu = menu;
    }

    public void filter() {
        print(
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList())
        );
    }

    public void distinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        System.out.println();
    }

    public void limit() {
        print(
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .limit(3)
                        .collect(toList())
        );
    }

    public void skip() {
        print(
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .skip(2)
                        .collect(toList())
        );
    }

    public void selectFirstTwoMeatDish() {
        print(
                menu.stream()
                        .filter(dish -> dish.getType().equals(Dish.Type.MEAT))
                        .limit(2)
                        .collect(toList())
        );
    }

    public static void main(String[] args) {
        FilterPractice practice = new FilterPractice(DishFactory.createDishesExample());

        practice.filter();
        practice.distinct();
        practice.limit();
        practice.skip();
        practice.selectFirstTwoMeatDish();
    }

}
