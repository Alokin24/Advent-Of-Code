package day11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    static int[] dx = {0, -1, 0, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 0, 1, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(".\\src\\day11\\input"));

        List<String> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }


        int N = lines.size();
        int M = lines.get(0).length();
        char[][] mat = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; ++j) {
                mat[i][j] = lines.get(i).charAt(j);
            }
        }

        // true -> occupy empty seats
        // false -> empty occupied seats
        boolean occupy = true;

        while (true) {
            List<IndicesPair> changes = new ArrayList<>();

            if (occupy) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (canBeOccupied(i, j, mat, N, M)) {
                            changes.add(new IndicesPair(i, j));
                        }
                    }
                }

                if (changes.isEmpty()) {
                    break;
                }
                for (IndicesPair ip : changes) {
                    mat[ip.i][ip.j] = '#';
                }
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (canBeEmptied(i, j, mat, N, M)) {
                            changes.add(new IndicesPair(i, j));
                        }
                    }
                }
                if (changes.isEmpty()) {
                    break;
                }
                for (IndicesPair ip : changes) {
                    mat[ip.i][ip.j] = 'L';
                }
            }

            occupy = !occupy;
        }

        int occupied = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j] == '#') {
                    occupied++;
                }
            }
        }

        System.out.println(occupied);

    }

    static boolean canBeOccupied(int x, int y, char[][] mat, int N, int M) {
        boolean okay = mat[x][y] == 'L';

        for (int i = 0; i < 8; i++) {
            int xi = x + dx[i];
            int yi = y + dy[i];

            if (xi >= 0 && xi < N && yi >= 0 && yi < M) {
                okay &= mat[xi][yi] != '#';
            }
        }

        return okay;
    }

    static boolean canBeEmptied(int x, int y, char[][] mat, int N, int M) {
        int occupied = 0;

        if (mat[x][y] != '#')
            return false;

        for (int i = 0; i < 8; i++) {
            int xi = x + dx[i];
            int yi = y + dy[i];

            occupied += ((xi >= 0) && (xi < N) && (yi >= 0) && (yi < M) && (mat[xi][yi] == '#')) ? 1 : 0;
        }

        return occupied >= 4;
    }

}


