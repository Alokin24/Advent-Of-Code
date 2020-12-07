package day4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
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

            Map<String, String> has = new HashMap<>();
            for (String s : credentials) {
                String[] parts = s.split(" ");
                for (String part : parts) {
                    String[] cred = part.split(":");
                    has.put(cred[0], cred[1]);
                }
            }

            if (has.size() == 8 || (has.size() == 7 && !has.containsKey("cid"))) {
                boolean okay = true;

                int birthYear = Integer.parseInt(has.get("byr"));
                int issueYear = Integer.parseInt(has.get("iyr"));
                int expirationYear = Integer.parseInt(has.get("eyr"));
                String height = has.get("hgt");
                String hairColor = has.get("hcl");
                String eyeColor = has.get("ecl");
                String passportId = has.get("pid");

                Set<String> allowedEyeColors = new HashSet<>();
                allowedEyeColors.addAll(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));

                okay &= (birthYear >= 1920  && birthYear <= 2002);
                okay &= (issueYear >= 2010 && issueYear <= 2020);
                okay &= (expirationYear >= 2020 && expirationYear <= 2030);

                int heightNumber = (height.length() >= 3) ? Integer.parseInt(height.substring(0, height.length()-2)) : 0;
                String heightME = (height.length() >= 3) ? height.substring(height.length()-2) : "";

                okay &= (heightNumber >= 150 && heightNumber <= 193 && heightME.equals("cm")) ||
                        (heightNumber >= 59 && heightNumber <= 76 && heightME.equals("in"));

                okay &= (hairColor.length() == 7) &&
                        (hairColor.charAt(0) == '#') &&
                        ((hairColor.charAt(1) >= '0' && hairColor.charAt(1) <= '9') || (hairColor.charAt(1) >= 'a' && hairColor.charAt(1) <= 'f'))  &&
                        ((hairColor.charAt(2) >= '0' && hairColor.charAt(2) <= '9') || (hairColor.charAt(2) >= 'a' && hairColor.charAt(2) <= 'f'))  &&
                        ((hairColor.charAt(3) >= '0' && hairColor.charAt(3) <= '9') || (hairColor.charAt(3) >= 'a' && hairColor.charAt(3) <= 'f'))  &&
                        ((hairColor.charAt(4) >= '0' && hairColor.charAt(4) <= '9') || (hairColor.charAt(4) >= 'a' && hairColor.charAt(4) <= 'f'))  &&
                        ((hairColor.charAt(5) >= '0' && hairColor.charAt(5) <= '9') || (hairColor.charAt(5) >= 'a' && hairColor.charAt(5) <= 'f'))  &&
                        ((hairColor.charAt(6) >= '0' && hairColor.charAt(6) <= '9') || (hairColor.charAt(6) >= 'a' && hairColor.charAt(6) <= 'f'));

                okay &= (allowedEyeColors.contains(eyeColor));

                okay &= (passportId.length() == 9) &&
                        (Character.isDigit(passportId.charAt(0))) &&
                        (Character.isDigit(passportId.charAt(1))) &&
                        (Character.isDigit(passportId.charAt(2))) &&
                        (Character.isDigit(passportId.charAt(3))) &&
                        (Character.isDigit(passportId.charAt(4))) &&
                        (Character.isDigit(passportId.charAt(5))) &&
                        (Character.isDigit(passportId.charAt(6))) &&
                        (Character.isDigit(passportId.charAt(7))) &&
                        (Character.isDigit(passportId.charAt(8)));

                if (okay) ++valid;

            }

        }

        System.out.println(valid);
    }
}
