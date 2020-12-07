package day4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day4\\input"));

        int valid = 0;
        while (scanner.hasNextLine()) {
            List<String> credentials = new ArrayList<>();
            do {
                String line = scanner.nextLine();
                if (line.isBlank()) {
                    break;
                }
                credentials.add(line);
            } while (scanner.hasNextLine());

            Set<String> has = new HashSet<>();
            for (String s : credentials) {
                String[] parts = s.split(" ");
                for (String part : parts) {
                    String[] cred = part.split(":");
                    has.add(cred[0]);
                }
            }

            if (has.size() == 8 || (has.size() == 7 && !has.contains("cid"))) {
               ++valid;
            }

        }

        System.out.println(valid);
    }
}
