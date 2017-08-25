package ch07.practice;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterSpliteratorPractice {

    public static void main(String[] args) {
        String sentence = "I want to fuck you";
        Spliterator<Character> spliterator = new WordCounterSpliterator(sentence);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        System.out.println(wordCounter.getCounter());
    }

}
