package ch05.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RawTypeStreamPractice {

    private IntStream toIntStream(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue);
    }

    private Stream<Integer> toIntegerStream(IntStream intStream) {
        return intStream.boxed();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        RawTypeStreamPractice rawTypeStreamPractice = new RawTypeStreamPractice();
        IntStream intStream = rawTypeStreamPractice.toIntStream(numbers);
        rawTypeStreamPractice.toIntegerStream(intStream).forEach(System.out::println);
    }

}
