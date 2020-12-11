package day11;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    static int[] dx = {0, -1, 0, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 0, 1, 0, -1, 1, -1, 1};
    static final int NUMBER_DIRECTIONS = 8;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day11\\input"));

        List<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        int N = lines.size();
        int M = lines.get(0).length();

        Seat[][] mat = new Seat[N][M];


        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                mat[i][j] = new Seat(i, j, lines.get(i).charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < NUMBER_DIRECTIONS; k++) {
                    int xk = mat[i][j].x + dx[k];
                    int yk = mat[i][j].y + dy[k];

                    while (xk >= 0 && xk < N && yk >= 0 && yk < M && mat[xk][yk].status == '.') {
                        xk += dx[k];
                        yk += dy[k];
                    }

                    if (xk >= 0 && xk < N && yk >= 0 && yk < M) {
                        mat[i][j].addSeatThatCanBeSeen(mat[xk][yk]);
                    }
                }
            }
        }

        boolean occupy = true;

        while (true) {
            List<IndicesPair> changes = new ArrayList<>();

            if (occupy) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (canBeOccupied(mat[i][j])) {
                            changes.add(new IndicesPair(i, j));
                        }
                    }
                }

                if (changes.isEmpty()) {
                    break;
                }
                for (IndicesPair ip : changes) {
                    mat[ip.i][ip.j].status = '#';
                }
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (canBeEmptied(mat[i][j])) {
                            changes.add(new IndicesPair(i, j));
                        }
                    }
                }
                if (changes.isEmpty()) {
                    break;
                }
                for (IndicesPair ip : changes) {
                    mat[ip.i][ip.j].status = 'L';
                }
            }

            occupy = !occupy;
        }

        int occupied = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j].status == '#') {
                    occupied++;
                }
            }
        }

        System.out.println(occupied);

    }


    static boolean canBeOccupied(Seat seat) {
        if (seat.status != 'L')
            return false;

        boolean okay = true;

        for (Seat s : seat.seatsThatCanBeSeen) {
            okay &= s.status != '#';
        }
        return okay;
    }

    static boolean canBeEmptied(Seat seat) {
        if (seat.status != '#')
            return false;

        int occupied = 0;

        for (Seat s : seat.seatsThatCanBeSeen) {
            if (s.status == '#') {
                occupied++;
            }
        }

        return occupied >= 5;
    }
}



