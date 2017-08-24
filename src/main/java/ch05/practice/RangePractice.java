package ch05.practice;

import java.util.stream.IntStream;

public class RangePractice {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

}
