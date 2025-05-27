import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 0;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println(sb);
                return;
            }
            testCase++;
            map = new int[n][n];
            cost = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();
            sb.append("Problem " + testCase + ": " + cost[n - 1][n - 1]).append("\n");

        }
    }

    public static void bfs() {
        Queue<Coord> q = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        q.add(new Coord(0, 0));
        cost[0][0] = map[0][0];
        while (!q.isEmpty()) {
            Coord curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                int tempCost = map[nx][ny] + cost[curr.x][curr.y];
                if (tempCost < cost[nx][ny]) {
                    cost[nx][ny] = tempCost;
                    q.add(new Coord(nx, ny));
                }
            }
        }
    }

    public static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
