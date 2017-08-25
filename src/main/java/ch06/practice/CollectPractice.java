package ch06.practice;

import ch04.dataGenerator.DishFactory;
import ch04.model.Dish;
import ch05.dataGenerator.TransactionFactory;
import ch05.model.Transaction;

import java.util.List;

import static ch05.tool.PrintTool.print;
import static java.util.stream.Collectors.*;

public class CollectPractice {

    private List<Transaction> transactions;
    private List<Dish> menu;

    public CollectPractice(List<Transaction> transactions, List<Dish> menu) {
        this.transactions = transactions;
        this.menu = menu;
    }

    public void count() {
        print(
                transactions.stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        .count()
        );
    }

    public void sum() {
        print(
                menu.stream()
                        .collect(summingInt(Dish::getCalories))
        );
    }

    public void join() {
        print(
                menu.stream()
                        .map(Dish::getName)
                        .collect(joining(","))
        );
    }

    public void reduce() {
        print(
                menu.stream()
                        .collect(reducing(0, Dish::getCalories, (i, j) -> i + j))
        );
    }

    public void group() {
        print(
                menu.stream()
                        .collect(groupingBy(Dish::getType, groupingBy(Dish::getCalories)))
        );
    }

    public void partition() {
        print(
                menu.stream()
                        .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)))
        );
    }

    public static void main(String[] args) {
        CollectPractice practice = new CollectPractice(TransactionFactory.createTransactionExample(), DishFactory.createDishesExample());

        practice.count();
        practice.sum();
        practice.join();
        practice.reduce();
        practice.group();
        practice.partition();
    }

}
