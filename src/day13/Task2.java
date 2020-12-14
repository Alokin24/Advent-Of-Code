package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day14\\input"));
        long timeICanEarliestCatchABus = Long.parseLong(scanner.nextLine());

        String line = scanner.nextLine();
        String[] busTimesStrings = line.split(",");

        List<Long> busTimes = new ArrayList<>();

        for (String busTimeString : busTimesStrings) {
            if (!busTimeString.equals("x"))
                busTimes.add(Long.parseLong(busTimeString));
            else
                busTimes.add(new Long(0));
        }

        long ans = busTimes.get(0);
        long lcm = busTimes.get(0);
//        System.out.println(ans);



        for (int i = 1; i < busTimes.size(); ++i) {
            if (busTimes.get(i) != 0) {
                long theNumber = busTimes.get(i);
                long remainder = theNumber - (i % theNumber);
                while (ans % theNumber != remainder) {
                    ans += lcm;
                }
                lcm *= theNumber;
            }
        }


    }
}
