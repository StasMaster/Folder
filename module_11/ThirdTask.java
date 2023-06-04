package module_11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThirdTask {
    public static String extractAndSortNumbers(String[] array) {
        List<Integer> numbersList = Arrays.stream(array)
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        return numbersList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};
        String result = extractAndSortNumbers(array);
        System.out.println(result);
    }
}
