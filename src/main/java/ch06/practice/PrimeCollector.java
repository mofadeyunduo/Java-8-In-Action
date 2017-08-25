package ch06.practice;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static ch05.tool.PrintTool.print;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collectors.toList;

public class PrimeCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    private List<Integer> below(List<Integer> numbers, int limit) {
        return numbers.stream()
                .filter(i -> i < limit)
                .collect(toList());
    }

    private boolean isPrime(List<Integer> primes, int target) {
        int border = (int) Math.sqrt(target);
        return below(primes, target).stream()
                .noneMatch(i -> target % i == 0);
    }

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (map, i) -> {
            map.get(isPrime(map.get(Boolean.TRUE), i)).add(i);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
//        throw new UnsupportedOperationException();
        return null;
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }

    public static void main(String[] args) {
        print(
                IntStream.rangeClosed(2, 100).boxed()
                        .collect(new PrimeCollector())
        );
    }

}
