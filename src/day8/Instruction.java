package day8;

public class Instruction {
    String operation;
    int number;

    public Instruction(String operation, int number) {
        this.operation = operation;
        this.number = number;
    }

    @Override
    public String toString() {
        return operation + " " + number;
    }
}
