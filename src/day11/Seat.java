package day11;

import java.util.ArrayList;
import java.util.List;

public class Seat {
    int x, y;
    char status;

    List<Seat> seatsThatCanBeSeen = new ArrayList<>();

    public Seat(int x, int y, char status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }

    void addSeatThatCanBeSeen(Seat s) {
        seatsThatCanBeSeen.add(s);
    }

}
