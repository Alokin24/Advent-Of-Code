package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(".\\src\\day14\\input"));
        Map<Long, BitSet> map = new HashMap<>();

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

                BitSet valueBits = BitSet.valueOf(new long[]{value});
                MaskingService.applyMaskV1(mask, valueBits);
                map.put(index, valueBits);


//                System.out.println(matcher.group(1) + " " + matcher.group(2));
            }

        }

        long ans = map.keySet().stream()
                .filter(k -> map.get(k).cardinality() > 0)
                .mapToLong(k -> map.get(k).toLongArray()[0])
                .sum();
        System.out.println(ans);
    }


}
