package ch05.practice;

import ch04.dataGenerator.DishFactory;
import ch04.model.Dish;

import java.util.List;

public class FindAndMatchPractice {

    private List<Dish> menu;

    public FindAndMatchPractice(List<Dish> menu) {
        this.menu = menu;
    }

    public void anyMatch() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }

    public void allMatch() {
        if (menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("All dishes calories is below 1000!");
        }
    }

    public void noneMatch() {
        if (menu.stream().noneMatch(dish -> dish.getCalories() > 1000)) {
            System.out.println("No dishes calories is over 1000!");
        }
    }

    public void findAny() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);
    }

    public void findFirst() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        FindAndMatchPractice practice = new FindAndMatchPractice(DishFactory.createDishesExample());

        practice.anyMatch();
        practice.allMatch();
        practice.noneMatch();
        practice.findAny();
        practice.findFirst();
    }

}
