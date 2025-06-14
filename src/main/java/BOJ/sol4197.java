package BOJ;

import java.io.*;
import java.util.*;

public class sol4197 {
    static int r, c;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static int[][] jihoonTime;
    static int[][] fireTime;
    static boolean isPossible = false;
    static Queue<Coord> fireQ = new LinkedList<>();
    static Queue<Coord> jihoonQ = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        jihoonTime = new int[r][c];
        fireTime = new int[r][c];

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = input.charAt(j);
                map[i][j] = c;
                fireTime[i][j] = -1;
                jihoonTime[i][j] = -1;

                if (c == 'F') {
                    fireQ.add(new Coord(i, j));
                    fireTime[i][j] = 0;
                }
                if (c == 'J') {
                    if (isEdge(i, j)) {
                        System.out.println(1);
                        return;
                    }
                    jihoonQ.add(new Coord(i, j));
                    jihoonTime[i][j] = 0;
                }
            }
        }
        fireBfs();
        jihoonBfs();
        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void fireBfs() {
        while (!fireQ.isEmpty()) {
            Coord curr = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (isOutOfRange(nx, ny) || fireTime[nx][ny] != -1 || map[nx][ny] == '#') {
                    continue;
                }
                fireTime[nx][ny] = fireTime[curr.x][curr.y] + 1;
                fireQ.add(new Coord(nx, ny));
            }
        }
    }


    public static void jihoonBfs() {
        while (!jihoonQ.isEmpty()) {
            Coord curr = jihoonQ.poll();
            if (isEdge(curr.x, curr.y)) {
                System.out.println(jihoonTime[curr.x][curr.y] + 1);
                isPossible = true;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (isOutOfRange(nx, ny) || jihoonTime[nx][ny] != -1 || map[nx][ny] == '#'
                        || (fireTime[nx][ny] != -1 && fireTime[nx][ny]
                        <= jihoonTime[curr.x][curr.y] + 1)) {
                    continue;
                }
                jihoonTime[nx][ny] = jihoonTime[curr.x][curr.y] + 1;
                jihoonQ.add(new Coord(nx, ny));
            }
        }

    }

    public static boolean isOutOfRange(int x, int y) {
        if (x < 0 || y < 0 || x >= r || y >= c) {
            return true;
        }
        return false;
    }

    public static boolean isEdge(int x, int y) {
        if (x == 0 || y == 0 || x == r - 1 || y == c - 1) {
            return true;
        }
        return false;
    }

    public static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
