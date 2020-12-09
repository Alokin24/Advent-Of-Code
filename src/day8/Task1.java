package day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day8\\input"));

        List<Instruction> instructionList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String operaton = scanner.next();
            int number = scanner.nextInt();
            System.out.println(operaton + " " + number);

            instructionList.add(new Instruction(operaton, number));

            // read \n so we can continue on the next line
            scanner.nextLine();

        }

        Map<Integer, Boolean> visitedInstruction = new HashMap<>();
        int curr = 0;

        int accumulator = 0;

        while (!visitedInstruction.getOrDefault(curr, false)) {
            Instruction i = instructionList.get(curr);
            visitedInstruction.put(curr, true);

            System.out.println(i);
            // execute the operation
            switch (i.operation) {
                case "acc": {
                    accumulator += i.number;
                    curr++;
                    break;
                }

                case "nop": {
                    curr++;
                    break;
                }

                case "jmp": {
                    curr += i.number;
                    break;
                }
            }
        }

        System.out.println(accumulator);

    }
}
