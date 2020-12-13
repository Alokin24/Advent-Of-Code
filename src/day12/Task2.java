package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day12\\input"));

        Map<Direction, Integer> pathTraveled = new HashMap<>();

        Waypoint waypoint = new Waypoint();
        DirectionService directionService =  new DirectionServiceImpl();
        waypoint.setDirectionService(directionService);

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
                    int pathInDir1 = pathTraveled.get(waypoint.x);
                    int pathInDir2 = pathTraveled.get(waypoint.y);
                    pathInDir1 += waypoint.unitsX * value;
                    pathInDir2 += waypoint.unitsY * value;

                    pathTraveled.put(waypoint.x, pathInDir1);
                    pathTraveled.put(waypoint.y, pathInDir2);
                    break;
                }
                case 'L': {
                    waypoint.moveLeft(value);
                    break;
                }
                case 'R': {
                    waypoint.moveRight(value);
                    break;
                }
                case 'E': {
                    waypoint.move(Direction.EAST, value);
                    break;
                }
                case 'S': {
                    waypoint.move(Direction.SOUTH, value);
                    break;
                }
                case 'W': {
                    waypoint.move(Direction.WEST, value);
                    break;
                }
                case 'N': {
                    waypoint.move(Direction.NORTH, value);
                    break;
                }
            }
        }

        int manhattan = Math.abs(pathTraveled.get(Direction.EAST) - pathTraveled.get(Direction.WEST))
                + Math.abs(pathTraveled.get(Direction.SOUTH) - pathTraveled.get(Direction.NORTH));

        System.out.println(manhattan);
    }
}
