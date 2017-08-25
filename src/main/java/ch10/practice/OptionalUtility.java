package ch10.practice;

import java.util.Optional;

public class OptionalUtility {

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException ignored) {
        }
        return Optional.empty();
    }

}
