package day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day3\\input"));

        ArrayList<String> mat = new ArrayList<>();

        while (scanner.hasNextLine()) {
            mat.add(scanner.nextLine());
        }

        int n, m;
        n = mat.size();
        m = mat.get(0).length();
        int x, y;
        x = 1;
        y = 3 % m;

        int treesEncountered = 0;

        while (x < n) {
            if (mat.get(x).charAt(y) == '#') {
                treesEncountered++;
            }
            x++;
            y = (y + 3) % m;
        }

        System.out.println(treesEncountered);

    }
}
