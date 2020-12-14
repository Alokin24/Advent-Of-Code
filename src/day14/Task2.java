package day14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(".\\src\\day14\\input"));
        Map<Long, Long> map = new HashMap<>();

        Pattern maskPattern = Pattern.compile("mask = (.*)");
        Pattern memPattern = Pattern.compile("mem\\[(.*)\\] = (.*)");

        String mask = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
//            System.out.println(line);

            Matcher matcher;
            matcher = maskPattern.matcher(line);
            if (matcher.find()) {
//                System.out.println(matcher.group(1));
                mask = matcher.group(1);
            } else {
                matcher = memPattern.matcher(line);
                matcher.find();
                long index = Long.parseLong(matcher.group(1));
                long value = Long.parseLong(matcher.group(2));

                BitSet indexBits = BitSet.valueOf(new long[]{index});

                List<BitSet> theNumbers = MaskingService.applyMaskV2(mask, indexBits);

                theNumbers.stream()
                    .forEach(bs -> map.put(bs.toLongArray()[0], value));

//                System.out.println(matcher.group(1) + " " + matcher.group(2));
            }

        }

        long ans = map.entrySet().stream().mapToLong(e -> e.getValue()).sum();
        System.out.println(ans);
    }
}
