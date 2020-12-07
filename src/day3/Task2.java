package day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day3\\input"));

        ArrayList<String> mat = new ArrayList<>();

        while (scanner.hasNextLine()) {
            mat.add(scanner.nextLine());
        }

        int[] xi = new int[]{1, 1, 1, 1, 2};
        int[] yi = new int[]{1, 3, 5, 7, 1};
        int n, m;
        n = mat.size();
        m = mat.get(0).length();

        long total = 1;
        for (int i = 0; i < xi.length; ++i) {
            int x, y;
            x = xi[i];
            y = yi[i] % m;

            System.out.println(x + " " + y);

            int treesEncountered = 0;

            while (x < n) {
                if (mat.get(x).charAt(y) == '#') {
                    treesEncountered++;
                }
                x += xi[i];
                y = (y + yi[i]) % m;
            }
            total *= treesEncountered;
        }

        System.out.println(total);
    }
}
