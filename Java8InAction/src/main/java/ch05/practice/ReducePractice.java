package ch05.practice;

import ch04.dataGenerator.DishFactory;
import ch04.model.Dish;

import java.util.Arrays;
import java.util.List;

import static ch05.tool.PrintTool.print;

public class ReducePractice {

    private List<Dish> menu;
    private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    public ReducePractice(List<Dish> menu) {
        this.menu = menu;
    }

    public void sum() {
        print(
                numbers.stream()
                        .reduce(0, Integer::sum)
        );
    }

    public void max() {
        print(
                numbers.stream()
                        .reduce(Integer.MIN_VALUE, Integer::max)
        );
    }

    public static void main(String[] args) {
        ReducePractice practice = new ReducePractice(DishFactory.createDishesExample());

        practice.sum();
        practice.max();
    }

}
