package day14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchingExamples {
        public static void main(String[] args) {
        String s = "mask = X011X00011011110001X01010011X0X0X010";
        Pattern pattern = Pattern.compile("mask = (.*)");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find())
            System.out.println(matcher.group(1));

        Pattern pattern1 = Pattern.compile("mem\\[(.*)\\] = (.*)");
        Matcher matcher1 = pattern1.matcher("mem[115] = 642");
        if (matcher1.find()) {
                System.out.println(matcher1.group(0));
                System.out.println(matcher1.group(1));
                System.out.println(matcher1.group(2));

        }
    }
}
