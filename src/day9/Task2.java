package day9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day9\\input"));

        List<Long> numbers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            numbers.add(Long.parseLong(line));
        }

        long invalidNumber = 542529149;

        long sum = 0;
        int left = 0, right = 0;
        for (int i = 0; i < numbers.size(); i++) {
            long curr = numbers.get(i);

            while (sum + curr > invalidNumber) {
                sum -= numbers.get(left);
                left++;
            }

            if (sum + curr == invalidNumber) {
                right = i;
                long biggest = Long.MIN_VALUE;
                long smallest = Long.MAX_VALUE;
                for (int j = left; j <= right; ++j) {
                    if (numbers.get(j) > biggest) {
                        biggest = numbers.get(j);
                    }
                    if (numbers.get(j) < smallest) {
                        smallest = numbers.get(j);
                    }
                }
                System.out.println(biggest + smallest);
            } else if (sum + curr < invalidNumber) {
                right = i;
                sum += curr;
            }
        }
    }
}
