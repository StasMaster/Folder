package module_11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstTask {
    public static String formatNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> (i + 1) % 2 != 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> namesList = List.of("Ivan", "Maria", "Peter", "Olga", "John", "Nekifor", "Fedot", "Elisey", "Feofan");
        String formattedNames = formatNames(namesList);
        System.out.println(formattedNames);
    }
}
