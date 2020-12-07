package day1;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(".\\src\\day1\\input.txt"));
        String line;

        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            int number = Integer.parseInt(line);
            System.out.println(number);
            map.put(number, true);
        }

        Optional<Integer> theNumber = map.keySet().stream().filter(k -> map.containsKey(2020 - k)).findFirst();

        if (theNumber.isPresent()) {
            System.out.println(theNumber.get() * (2020 - theNumber.get()));
        }

    }
}
