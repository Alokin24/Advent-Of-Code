package day9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day9\\input"));

        List<Long> numbers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            numbers.add(Long.parseLong(line));
        }

        Map<Long, Integer> last25 = new HashMap<>();

        for (int i = 0; i < 25; ++i) {
            // we count for each number how many times he appears in the last 25
            // for number[i], we get his value (or we get 0 if he doesn't exist) and we increase it by 1
            last25.put(numbers.get(i), last25.getOrDefault(numbers.get(i), 0) + 1);
        }

        for (int i = 25; i < numbers.size(); ++i) {
            long curr = numbers.get(i);

            boolean okay = false;
            for (int j = i-25; j < i; ++j) {
                long num1 = numbers.get(j);

                if (last25.getOrDefault(curr - num1, 0) != 0) {
                    okay = true;
                    break;
                }
            }

            if (!okay) {
                System.out.println(curr);
                break;
            }

            // decrement the number of apperances of the first guy in the list of 25
            long lastNumber = numbers.get(i-25);
            int lastNumberFreq = last25.get(lastNumber);
            lastNumberFreq--;
            last25.put(lastNumber, lastNumberFreq);

            // add a new numer to the list of 25
            long newNumber = numbers.get(i);
            int newNumberFreq = last25.getOrDefault(newNumber, 0);
            newNumberFreq++;
            last25.put(newNumber, newNumberFreq);
        }
    }
}
