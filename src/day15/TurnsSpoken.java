package day15;

public class TurnsSpoken<T> {
    int lastTurn;
    int turnBeforeLast = 0;

    public TurnsSpoken(int lastTurn) {
        this.lastTurn = lastTurn;
    }

    public int getNext() {
        if (turnBeforeLast == 0)
            return 0;
        return lastTurn - turnBeforeLast;
    }

    public void setLastTurn(int turn) {
        turnBeforeLast = lastTurn;
        lastTurn = turn;
    }
}
