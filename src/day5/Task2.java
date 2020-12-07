package day5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day5\\input"));

        String seatOrder;

        int max = -1;

        List<Integer> seatIds = new ArrayList<>();

        while (scanner.hasNextLine()) {
            seatOrder = scanner.nextLine();

            // gets all characters except the last 3
            String rowOrder = seatOrder.substring(0, seatOrder.length() - 3);
            // gets the last 3
            String colOrder = seatOrder.substring(seatOrder.length() - 3);

            int rowNumber = 0, colNumber = 0;

            for (int i = rowOrder.length() -1; i >= 0; i--) {
                // FBFB is actually a binary number 0101
                // every F is 0
                // every B is 1
                // so we only need to convert the binary number to decimal
                rowNumber += ((rowOrder.charAt(i) == 'B') ? 1 : 0) * Math.pow(2, rowOrder.length() - 1 - i);
            }

            for (int i = colOrder.length() - 1; i >= 0; i--) {
                colNumber += ((colOrder.charAt(i) == 'R') ? 1 : 0) * Math.pow(2, colOrder.length() - 1 - i);
            }

            seatIds.add(rowNumber * 8 + colNumber);
        }

        seatIds.sort(Integer::compareTo);

        for (int i = 1; i < seatIds.size() - 1; ++i) {
            int current = seatIds.get(i);
            int prev = seatIds.get(i-1);
            if (current != prev + 1) {
                // that means that our seat is between current and prev
                System.out.println(current - 1);
                break;
            }
        }

    }

    static void someTests() {
        String colOrder = "FFB";

        int lower = 0;
        int upper = 7;
        for (char c : colOrder.toCharArray()) {
            int middle = (lower + upper) / 2;
            if (c == 'B') {
                lower = middle + 1;
            } else {
                upper = middle;
            }
        }
        int colNumber = upper;
        System.out.println(colNumber);

    }
}
