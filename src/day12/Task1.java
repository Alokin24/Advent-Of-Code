package day12;

import day11.IndicesPair;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day12\\input"));

        Map<Direction, Integer> pathTraveled = new HashMap<>();
        DirectionService directionService = new DirectionServiceImpl();

        Direction curr = Direction.EAST;

        pathTraveled.put(Direction.EAST, 0);
        pathTraveled.put(Direction.SOUTH, 0);
        pathTraveled.put(Direction.WEST, 0);
        pathTraveled.put(Direction.NORTH, 0);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            char direction = line.charAt(0);
            int value = Integer.parseInt(line.substring(1));

            switch (direction) {
                case 'F': {
                    pathTraveled.put(curr, pathTraveled.get(curr) + value);
                    break;
                }
                case 'L': {
                    curr = directionService.moveLeft(value, curr);
                    break;
                }
                case 'R': {
                    curr = directionService.moveRight(value, curr);
                    break;
                }
                case 'E': {
                    pathTraveled.put(Direction.EAST, pathTraveled.get(Direction.EAST) + value);
                    break;
                }
                case 'S': {
                    pathTraveled.put(Direction.SOUTH, pathTraveled.get(Direction.SOUTH) + value);
                    break;
                }
                case 'W': {
                    pathTraveled.put(Direction.WEST, pathTraveled.get(Direction.WEST) + value);
                    break;
                }
                case 'N': {
                    pathTraveled.put(Direction.NORTH, pathTraveled.get(Direction.NORTH) + value);
                    break;
                }
            }
        }

        int manhattan = Math.abs(pathTraveled.get(Direction.EAST) - pathTraveled.get(Direction.WEST))
                + Math.abs(pathTraveled.get(Direction.SOUTH) - pathTraveled.get(Direction.NORTH));

        System.out.println(manhattan);


    }


}
