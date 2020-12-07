package day1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day1\\input.txt"));
        String line;
        List<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            numbers.add(Integer.parseInt(line));
        }

        Map<Integer, SumaNaDvaBroja> map = new HashMap<>();

        for (int i = 0; i < numbers.size(); ++i) {
            for (int j = i+1; j < numbers.size(); ++j) {
                map.put(numbers.get(i) + numbers.get(j), new SumaNaDvaBroja(numbers.get(i), numbers.get(j)));
            }
        }

        Optional<Integer> ans = numbers.stream().filter(t -> map.containsKey(2020-t)).findFirst();

        int number1 = ans.get();
        int number2 = map.get(2020-number1).prv;
        int number3 = map.get(2020-number1).vtor;

        System.out.println(number1 * number2 * number3);

    }

}

class SumaNaDvaBroja {
    int prv;
    int vtor;
    SumaNaDvaBroja(int prv, int vtor) {
        this.prv = prv;
        this.vtor = vtor;
    }
}
