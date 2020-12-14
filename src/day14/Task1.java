package day14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day14\\input"));

        long timeICanEarliestCatchABus = Long.parseLong(scanner.nextLine());

        String line = scanner.nextLine();
        String[] busTimesStrings = line.split(",");

        List<Integer> busTimes = new ArrayList<>();

        for (String busTimeString : busTimesStrings) {
            if (!busTimeString.equals("x"))
            busTimes.add(Integer.parseInt(busTimeString));
        }

        long busId = 0;
        long minSoFar = Long.MAX_VALUE;

        for (int busTime : busTimes) {
            long timeToWait = busTime - timeICanEarliestCatchABus % busTime;
            if (timeToWait < minSoFar) {
                minSoFar = timeToWait;
                busId = busTime;
            }
        }

        System.out.println(busId * minSoFar);
    }
}
