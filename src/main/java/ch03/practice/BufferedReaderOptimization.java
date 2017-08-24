package ch03.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderOptimization {

    public void read(String file, BufferedReaderProcessor processor) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            processor.process(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedReaderOptimization bufferedReaderOptimization = new BufferedReaderOptimization();
        bufferedReaderOptimization.read(
                BufferedReaderOptimization.class.getResource("/NumberForEachLine.txt").getFile(),
                reader -> System.out.println(reader.readLine())
        );
        System.out.println();

        bufferedReaderOptimization.read(
                BufferedReaderOptimization.class.getResource("/NumberForEachLine.txt").getFile(),
                reader -> System.out.println((char) reader.read())
        );
    }

}
