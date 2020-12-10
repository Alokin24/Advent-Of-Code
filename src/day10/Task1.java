package day10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
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


        int diff1 = 0, diff2 = 0, diff3 = 0;
        int begining = 0;

        for (int i = 0; i < numbers.size(); ++i) {
            int diff = numbers.get(i) - begining;
            switch (diff) {
                case 1: {
                    diff1++;
                    break;
                }
                case 2: {
                    diff2++;
                    break;
                }
                case 3: {
                    diff3++;
                    break;
                }
            }

            begining = numbers.get(i);
        }


        System.out.println(diff1 * diff3);
    }
}
