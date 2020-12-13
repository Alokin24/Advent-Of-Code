package day12;

import java.util.HashMap;
import java.util.Map;

public class Waypoint {
    Direction x;
    Direction y;

    int unitsX;
    int unitsY;

    DirectionService directionService;

    public void setDirectionService(DirectionService directionService) {
        this.directionService = directionService;
    }

    public Waypoint() {
        this.x = Direction.EAST;
        this.y = Direction.NORTH;

        this.unitsX = 10;
        this.unitsY = 1;
    }

    public void move(Direction direction, int units) {
        switch (direction) {
            case EAST:
            case WEST: {
                if (this.x == direction) {
                    this.unitsX += units;
                } else {
                    if (this.unitsX > units) {
                        this.unitsX -= units;
                    } else {
                        this.x = directionService.getOppositeDirection(this.x);
                        this.unitsX = units - this.unitsX;
                    }
                }
                break;
            }
            case NORTH:
            case SOUTH: {
                if (this.y == direction) {
                    this.unitsY += units;
                } else {
                    if (this.unitsY > units) {
                        this.unitsY -= units;
                    } else {
                        this.y = directionService.getOppositeDirection(this.y);
                        this.unitsY = units - this.unitsY;
                    }
                }

            }
        }
    }

    public void moveLeft(int degrees) {
        if (Math.abs(degrees) == 90 || Math.abs(degrees) == 270) {
            // we need to swap the values for units in X and Y direction
            Direction tmpX = this.x;
            int tmpUnitsX = this.unitsX;

            this.x = directionService.moveLeft(degrees, this.y);
            this.unitsX = this.unitsY;

            this.y = directionService.moveLeft(degrees, tmpX);
            this.unitsY = tmpUnitsX;
        } else {
            this.x = directionService.moveLeft(degrees, this.x);
            this.y = directionService.moveLeft(degrees, this.y);
        }
    }

    public void moveRight(int degrees) {
        moveLeft(degrees * (-1));
    }

    public static void main(String[] args) {
        Waypoint w1 = new Waypoint();
        DirectionService directionService = new DirectionServiceImpl();
        w1.setDirectionService(directionService);

        System.out.println(w1.x + " " + w1.y);

//        w1.move(Direction.NORTH, 100);
//        System.out.println(w1.x + " " + w1.y);
//
//        w1.move(Direction.SOUTH, 200);
//        System.out.println(w1.x + " " + w1.y);
//
//        w1.move(Direction.EAST, 100);
//        System.out.println(w1.x + " " + w1.y);
//
//        w1.move(Direction.WEST, 200);
//        System.out.println(w1.x + " " + w1.y);

//        w1.moveRight(90);
//        System.out.println(w1.x + " " + w1.y);
//        System.out.println(w1.unitsX + " " + w1.unitsY);
    }
}
