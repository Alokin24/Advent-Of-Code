package day12;

import java.util.HashMap;
import java.util.Map;

public class DirectionServiceImpl implements DirectionService {

    private Map<Direction, Direction> opposites = new HashMap<>();

    public DirectionServiceImpl() {
        opposites.put(Direction.WEST, Direction.EAST);
        opposites.put(Direction.EAST, Direction.WEST);
        opposites.put(Direction.SOUTH, Direction.NORTH);
        opposites.put(Direction.NORTH, Direction.SOUTH);
    }

    @Override
    public Direction getOppositeDirection(Direction direction) {
        return opposites.get(direction);
    }

    public Direction moveRight(int degrees, Direction curr) {
        int directionChanges = (degrees / 90) % Direction.NUM_DIRECTIONS;

        // this gets the new direction by adding the current direction + direction changes and getting the positive number from applying modulus by NUM_DIRECTIONS
        int newDirection = ((curr.ordinal() + directionChanges) % Direction.NUM_DIRECTIONS + Direction.NUM_DIRECTIONS) % Direction.NUM_DIRECTIONS;

        return Direction.values()[newDirection];
    }

    public Direction moveLeft(int degrees, Direction curr) {
        return moveRight(degrees * (-1), curr);
    }

    public static void main(String[] args) {
        Direction d = Direction.EAST;

        DirectionService directionService = new DirectionServiceImpl();

        System.out.println(directionService.moveLeft(270, d));
        System.out.println(directionService.moveRight(270, d));
        System.out.println(directionService.getOppositeDirection(d));
        System.out.println(directionService.getOppositeDirection(directionService.getOppositeDirection(d)));
    }
}
