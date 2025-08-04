package BOJ;

import java.io.*;
import java.util.*;

public class sol21736 {
    static int n, m;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        Coord doyeon = new Coord(-1, -1);
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if (c == 'I') {
                    doyeon.x = i;
                    doyeon.y = j;
                }
                map[i][j] = c;
            }
        }
        int met = bfs(doyeon);
        if (met > 0) {
            System.out.println(met);
        } else {
            System.out.println("TT");
        }
    }

    public static int bfs(Coord start) {
        int count = 0;
        Queue<Coord> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Coord curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 'X' || visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 'P') {
                    count++;
                }
                visited[nx][ny] = true;
                q.add(new Coord(nx, ny));
            }
        }
        return count;
    }

    public static class Coord {
        int x, y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
