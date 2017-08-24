package ch05.tool;

import java.util.List;
import java.util.Map;

public class PrintTool {

    public static void print(List<?> elements) {
        elements.forEach(System.out::println);
        System.out.println();
    }

    public static void print(Map<?, ?> map) {
        map.forEach((key, value) -> System.out.println(key.toString().concat(": ").concat(value.toString())));
        System.out.println();
    }

    public static void print(Object obj) {
        System.out.println(obj.toString());
        System.out.println();
    }

}
