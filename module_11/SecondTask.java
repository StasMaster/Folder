package module_11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class SecondTask {
    public static List<String> uppercaseAndSort(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> stringsList = List.of("Ivan", "Maria", "Peter", "Olga", "John", "Nekifor", "Fedot", "Elisey", "Feofan");
        List<String> sortedList = uppercaseAndSort(stringsList);

        sortedList.forEach(System.out::println);
    }
}
