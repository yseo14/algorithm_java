import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }
        bfs();
        System.out.println(graph[n][m]);
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][m + 1];
        q.add(new Point(1, 1));
        visited[1][1] = true;
        while (!q.isEmpty()) {
            Point curr = q.poll();
            visited[curr.x][curr.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];
                if (newX < 1 || newY < 1 || newX > n || newY > m || visited[newX][newY] || graph[newX][newY] == 0) {
                    continue;
                }
                q.add(new Point(newX, newY));
                visited[newX][newY] = true;
                graph[newX][newY] = graph[curr.x][curr.y] + 1;
            }
        }
    }

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
