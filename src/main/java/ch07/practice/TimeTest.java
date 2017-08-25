package ch07.practice;

import java.util.stream.LongStream;

public class TimeTest {

    private interface TimeCountOperation {

        void operate();

    }

    private class Accumulator {

        private long total = 0;

        public void add(long value) {
            total += value;
        }

    }

    private void countTime(TimeCountOperation timeCountOperation, int count) {
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            long start = System.currentTimeMillis();
            timeCountOperation.operate();
            long end = System.currentTimeMillis();
            sum += end - start;
            System.out.println("no".concat(Integer.toString(i)).concat(":").concat(Long.toString(end - start)).concat(" ms"));
        }

        System.out.println("avg time: " + (double) sum / (double) count + " ms");
    }

    public void classicSum(long n) {
        System.out.println("---classic sum---");
        countTime(
                () -> {
                    long sum = 0;
                    for (long i = 1; i <= n; i++) {
                        sum += i;
                    }
                },
                10
        );

    }

    public void streamSum(long n) {
        System.out.println("---function sum---");
        countTime(
                () -> {
                    long result = LongStream.iterate(1, i -> i + 1)
                            .limit(n)
                            .sum();
                },
                10
        );
    }

    public void parallelStreamSum(long n) {
        System.out.println("---parallel stream sum---");
        countTime(
                () -> {
                    long result = LongStream.rangeClosed(1, n)
                            .parallel()
                            .sum();
                },
                10
        );
    }

    public void sharedSumGetWrongAnswer(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(accumulator::add);
        System.out.println(accumulator.total);
    }

    public static void main(String[] args) {
        TimeTest test = new TimeTest();

        long n = 10000000l;
        test.classicSum(n);
        test.streamSum(n);
        test.parallelStreamSum(n);

        test.sharedSumGetWrongAnswer(n);
        test.sharedSumGetWrongAnswer(n);
    }
}
