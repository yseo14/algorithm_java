
import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int i;
    static int[][] map;
    static boolean[][] visited;
    static int startX, startY;
    static int targetX, targetY;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            i = Integer.parseInt(br.readLine());
            map = new int[i][i];
            visited = new boolean[i][i];

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());
            bfs(startX, startY);
            System.out.println(map[targetX][targetY]);
        }
    }

    public static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int j = 0; j < 8; j++) {
                int newX = now.x + dx[j];
                int newY = now.y + dy[j];
                if ((newX >= 0 && newX < i) && (newY >= 0 && newY < i)) {
                    if (!visited[newX][newY]) {
                        q.add(new Point(newX, newY));
                        map[newX][newY] = map[now.x][now.y] + 1;
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
