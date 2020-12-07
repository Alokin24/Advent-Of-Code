package day5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(".\\src\\day5\\input"));

        String seatOrder;

        int max = -1;

        while (scanner.hasNextLine()) {
            seatOrder = scanner.nextLine();

            // gets all characters except the last 3
            String rowOrder = seatOrder.substring(0, seatOrder.length() - 3);
            // gets the last 3
            String colOrder = seatOrder.substring(seatOrder.length() - 3);

            int rowNumber, colNumber;

            int lower = 0;
            int upper = 127;
            for (char c : rowOrder.toCharArray()) {
                int middle = (lower + upper) / 2;
                if (c == 'B') {
                    lower = middle + 1;
                } else {
                    upper = middle;
                }
            }
            rowNumber = upper;

            lower = 0;
            upper = 7;
            for (char c : colOrder.toCharArray()) {
                int middle = (lower + upper) / 2;
                if (c == 'R') {
                    lower = middle + 1;
                } else {
                    upper = middle;
                }
            }
            colNumber = upper;

            int seatId = rowNumber * 8 + colNumber;
            max = Math.max(max, seatId);

        }

        System.out.println(max);

    }
}
