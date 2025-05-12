package BOJ;

import java.util.*;
import java.io.*;


public class sol2178_2 {

    static int[][] maze;
    static boolean[][] visited;
    static int n, m;
    static int result;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] str2Arr = line.toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(str2Arr[j]));
            }
        }

        result = 0;

        bfs(0, 0);
        System.out.println(maze[n - 1][m - 1]);

    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point start = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = start.x + dx[i];
                int newY = start.y + dy[i];

                if ((newX >= 0 && newX < n) && (newY >= 0 && newY < m)) {
                    if (maze[newX][newY] != 0 && !visited[newX][newY]) {
                        maze[newX][newY] = maze[start.x][start.y] + 1;
                        visited[newX][newY] = true;
                        q.add(new Point(newX, newY));
                        result++;
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
