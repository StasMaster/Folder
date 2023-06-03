package module_11;

import java.util.List;
import java.util.ArrayList;

public class ThirdTask {
    public static String extractAndSortNumbers(String[] array) {
        List<Integer> numbersList = new ArrayList<>();

        for (String str : array) {
            String[] splitArray = str.split(", ");

            for (String num : splitArray) {
                try {
                    int number = Integer.parseInt(num);
                    numbersList.add(number);
                } catch (NumberFormatException e) {
                }
            }
        }
        numbersList.sort(Integer::compareTo);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbersList.size(); i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(numbersList.get(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};
        String result = extractAndSortNumbers(array);
        System.out.println(result);
    }
}
