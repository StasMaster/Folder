package module_11;

import java.util.List;
public class FirstTask {
    public static String formatNames(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < names.size(); i++) {
            if ((i + 1) % 2 != 0) {
                int index = i + 1;
                String name = names.get(i);
                stringBuilder.append(index).append(". ").append(name).append(", ");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        List<String> namesList = List.of("Ivan", "Maria", "Peter", "Olga", "John", "Nekifor", "Fedot", "Elisey", "Feofan");
        String formattedNames = formatNames(namesList);
        System.out.println(formattedNames);
    }
}
