package ch03.practice;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {

    void process(BufferedReader reader) throws IOException;

}
