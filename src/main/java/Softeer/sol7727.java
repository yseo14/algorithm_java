package Softeer;

import java.io.*;
import java.util.*;

public class sol7727 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static List<Position> friends;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        friends = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            friends.add(new Position(x, y));
        }
        Position start = friends.get(0);
        backTracking(start, 0, 0, map[start.x][start.y]);
        System.out.println(result);
    }

    public static void backTracking(Position start, int friendIdx, int time, int sum) {
        visited[start.x][start.y] = true;
        if (time == 3) {
            if (friendIdx + 1 == m) {
                result = Math.max(sum, result);
            } else {
                Position next = friends.get(friendIdx + 1);
                backTracking(next, friendIdx + 1, 0, sum + map[next.x][next.y]);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = start.x + dx[i];
                int ny = start.y + dy[i];
                if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    backTracking(new Position(nx, ny), friendIdx, time + 1, sum + map[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
