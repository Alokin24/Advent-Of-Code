package day10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day10\\input"));

        List<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            numbers.add(Integer.parseInt(scanner.nextLine()));

        }

        numbers.sort(Integer::compareTo);

        // add our device
        int lastDevice = numbers.get(numbers.size() -1);
        numbers.add(lastDevice + 3);

        long[] dp = new long[numbers.get(numbers.size() - 1) + 1];
        dp[0] = 1;
        for (int i = 0; i < numbers.size(); i++) {
            int curr = numbers.get(i);
            if (curr -1 >= 0) {
                dp[curr] += dp[curr-1];
            }
            if (curr -2 >=0 ) {
                dp[curr] += dp[curr-2];
            }
            if (curr -3 >= 0) {
                dp[curr] += dp[curr-3];
            }
        }
        System.out.println(dp[numbers.get(numbers.size()-1)]);

    }
}
