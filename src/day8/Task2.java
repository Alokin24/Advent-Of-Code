package day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day8\\input"));

        List<Instruction> instructionList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String operaton = scanner.next();
            int number = scanner.nextInt();
            instructionList.add(new Instruction(operaton, number));

            // read \n so we can continue on the next line
            scanner.nextLine();

        }


        for (Instruction instruction : instructionList) {
            if (instruction.operation.equals("nop")) {
                instruction.operation = "jmp";
            } else if (instruction.operation.equals("jmp")) {
                instruction.operation = "nop";
            }

            int curr = 0;

            int accumulator = 0;

            Map<Integer, Boolean> visitedInstruction = new HashMap<>();
            while (curr < instructionList.size()) {
                Instruction i = instructionList.get(curr);
                visitedInstruction.put(curr, true);

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
                if (visitedInstruction.getOrDefault(curr, false)) {
                    break;
                }
            }

            if (curr >= instructionList.size()) {
                System.out.println(accumulator);
                break;
            }

            if (instruction.operation.equals("nop")) {
                instruction.operation = "jmp";
            } else if (instruction.operation.equals("jmp")) {
                instruction.operation = "nop";
            }
        }

    }
}
