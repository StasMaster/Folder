package module_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondTask {
    public static List<String> uppercaseAndSort(List<String> strings) {
        List<String> uppercaseList = new ArrayList<>();

        for (String str : strings) {
            uppercaseList.add(str.toUpperCase());
        }

        Collections.sort(uppercaseList, Collections.reverseOrder());

        return uppercaseList;
    }

    public static void main(String[] args) {
        List<String> stringsList = List.of("Ivan", "Maria", "Peter", "Olga", "John", "Nekifor", "Fedot", "Elisey", "Feofan");
        List<String> sortedList = uppercaseAndSort(stringsList);

        for (String str : sortedList) {
            System.out.println(str);
        }
    }
}