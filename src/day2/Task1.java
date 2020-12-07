package day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day2\\input"));

        int valid = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            int low, high;
            String[] interval = parts[0].split("-");
            low = Integer.parseInt(interval[0]);
            high = Integer.parseInt(interval[1]);

            char policyLetter = parts[1].charAt(0);

            String password = parts[2];

            Map<Character, Integer> map = new HashMap<>();

            password.chars().forEach(c -> {
                map.put((char) c, map.getOrDefault((char) c, 0) + 1);
            });

            int policyLetterFreq = map.getOrDefault(policyLetter, 0);
            System.out.println(policyLetterFreq + " " + policyLetter);

            if (policyLetterFreq >= low && policyLetterFreq <= high) {
                ++valid;
            }
        }

        System.out.println(valid);
    }
}









