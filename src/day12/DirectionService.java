package day12;

public interface DirectionService {
    public Direction getOppositeDirection(Direction direction);
    public Direction moveRight(int degrees, Direction current);
    public Direction moveLeft(int degrees, Direction current);
}
