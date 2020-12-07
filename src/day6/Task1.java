package day6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day6\\input"));

        int totalSum = 0;
        while (scanner.hasNextLine()) {
            String line;
            Set<Character> questions = new HashSet<>();

            line = scanner.nextLine();
            while (!line.isBlank()) {
                for (char c : line.toCharArray()) {
                    questions.add(c);
                }

                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                } else {
                    break;
                }
            }

            totalSum += questions.size();
        }
        System.out.println(totalSum);
    }
}
