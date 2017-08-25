package ch10.practice;

import java.util.Optional;
import java.util.Properties;

public class StringToIntPractice {

    public int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        StringToIntPractice practice = new StringToIntPractice();
        System.out.println(practice.readDuration(props, "1"));
        System.out.println(practice.readDuration(props, "2"));
        System.out.println(practice.readDuration(props, "3"));
    }

}
