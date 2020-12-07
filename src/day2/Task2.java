package day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day2\\input"));

        int valid = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            int pos1, pos2;
            String[] interval = parts[0].split("-");
            pos1 = Integer.parseInt(interval[0]);
            pos2 = Integer.parseInt(interval[1]);

            char policyLetter = parts[1].charAt(0);

            String password = parts[2];

            int okay1 = 0, okay2 = 0;

            if (password.length() >= pos1 -1 && password.charAt(pos1-1) == policyLetter) {
                okay1 = 1;
            }
            if (password.length() >= pos2 -1 && password.charAt(pos2-1) == policyLetter) {
                okay2 = 1;
            }

            valid += (okay1 ^ okay2);

        }

        System.out.println(valid);
    }
}









