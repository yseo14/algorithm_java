package BOJ;

import java.io.*;
import java.util.*;

public class sol4179_3 {
    static int r, c;
    static char[][] map;
    static int[][] jihoonTime;
    static int[][] fireTime;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean isPossible = false;
    static Queue<Coord> fireQueue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        jihoonTime = new int[r][c];
        fireTime = new int[r][c];

        Coord jihoon = null, fire = null;

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            Arrays.fill(jihoonTime[i], -1);
            Arrays.fill(fireTime[i], -1);

            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J') {
                    if (isEdge(i, j)) {     //  지훈이의 위치가 이미 가장자리인 경우 바로 탈출
                        System.out.println(1);
                        return;
                    }
                    jihoon = new Coord(i, j);
                    jihoonTime[i][j] = 0;
                }
                if (map[i][j] == 'F') {
                    fire = new Coord(i, j);
                    fireTime[i][j] = 0;
                    fireQueue.add(new Coord(i, j));
                }
            }
        }

        fireBfs(fire);
        jihoonBfs(jihoon);
        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        }
    }


    public static void fireBfs(Coord start) {
        while (!fireQueue.isEmpty()) {
            Coord curr = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (isOutOfRange(nx, ny) || fireTime[nx][ny] != -1 || map[nx][ny] == '#') {
                    continue;
                }
                fireTime[nx][ny] = fireTime[curr.x][curr.y] + 1;
                fireQueue.add(new Coord(nx, ny));
            }
        }
    }

    public static void jihoonBfs(Coord start) {
        Queue<Coord> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Coord curr = q.poll();
            if (isEdge(curr.x, curr.y)) {
                System.out.println(jihoonTime[curr.x][curr.y] + 1);
                isPossible = true;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (isOutOfRange(nx, ny) || jihoonTime[nx][ny] != -1 || map[nx][ny] == '#'
                        || (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= jihoonTime[curr.x][curr.y] + 1)) {
                    continue;
                }
                jihoonTime[nx][ny] = jihoonTime[curr.x][curr.y] + 1;
                q.add(new Coord(nx, ny));
            }
        }
    }

    public static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= r || y >= c;
    }

    public static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == r - 1 || y == c - 1;
    }

    public static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
