import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int maxSize;
    static int count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];


        maxSize = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);

    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        int size = 0;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            visited[curr.x][curr.y] = true;
            size++;
            for (int i = 0; i < 4; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];

                if ((newX >= 0 && newX < n) && (newY >= 0 && newY < m)) {
                    if (map[newX][newY] == 1 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        q.add(new Point(newX, newY));
                    }
                }
            }
        }
        maxSize = Math.max(size, maxSize);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
