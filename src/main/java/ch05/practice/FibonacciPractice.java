package ch05.practice;

import java.util.stream.Stream;

public class FibonacciPractice {

    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .mapToInt(t -> t[0])
                .forEach(System.out::println);
    }

}
