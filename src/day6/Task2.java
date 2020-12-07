package day6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day6\\input"));

        int totalSum = 0;
        while (scanner.hasNextLine()) {
            String line;

            Map<Character, Integer> questionsFreq= new HashMap<>();


            int persons = 0;
            line = scanner.nextLine();
            while (!line.isBlank()) {
                ++persons;

                for (char c : line.toCharArray()) {
                    questionsFreq.put(c, questionsFreq.getOrDefault(c, 0) + 1);
                }

                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                } else {
                    break;
                }
            }

            final int totalPersons = persons;

            totalSum += questionsFreq.values().stream().filter(v -> v == totalPersons).count();

        }
        System.out.println(totalSum);
    }
}
