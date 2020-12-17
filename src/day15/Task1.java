package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String input = "12,20,0,6,1,17,7";
//        String input = "0,3,6";
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(input);

        int turn = 1;
        Map<Integer, TurnsSpoken> numberTurnsSpoken = new HashMap<>();

        int lastNumber = -1;

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            lastNumber = number;
            numberTurnsSpoken.put(number, new TurnsSpoken(turn));
            turn++;
        }

        while (turn <= 2020) {
            TurnsSpoken turnsSpoken = numberTurnsSpoken.get(lastNumber);
            // returns the difference between last two turns when lastNumber was spoken
            // or returns 0 if the number was spoken only 1 turn so far
            lastNumber = turnsSpoken.getNext();

            // if number was already spoken before
            // update the number of last two turns when it was spoken
            if (numberTurnsSpoken.containsKey(lastNumber)) {
                TurnsSpoken updateTurnsSpokenOfLastNumber = numberTurnsSpoken.get(lastNumber);
                updateTurnsSpokenOfLastNumber.setLastTurn(turn);
            } else {
                // add a new number that was spoken only once and set lastTurn to turn
                numberTurnsSpoken.put(lastNumber, new TurnsSpoken(turn));
            }
//            System.out.println(lastNumber);
            turn++;
        }

        System.out.println(lastNumber);



    }
}
