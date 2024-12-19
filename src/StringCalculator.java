import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                negatives.add(num);
            }
            sum += num;
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negative numbers not allowed "+ negatives.toString().replaceAll("[\\[\\]]", "")
            );
        }

        return sum;
    }



}
