import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static Queue<Point> q;
    static PriorityQueue<Point> pq;
    static int currSize = 2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    q.offer(new Point(i, j, 0));
                }
            }
        }
        bfs();
        int move = 0;
        int eat = 0;
        while (!pq.isEmpty()) {
            Point now = pq.poll();
            map[now.x][now.y] = 0;
            eat++;
            if (eat == currSize) {
                eat = 0;
                currSize++;
            }
            move += now.dist;
            q = new LinkedList<>();
            q.offer(new Point(now.x, now.y, 0));
            bfs();
        }
        System.out.println(move);
    }

    public static void bfs() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] visited = new boolean[n][n];
        pq = new PriorityQueue<>();

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || map[nx][ny] > currSize) {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, now.dist + 1));
                if (map[nx][ny] != 0 && currSize > map[nx][ny]) {
                    pq.offer(new Point(nx, ny, now.dist + 1));
                }
            }
        }
    }
    public static class Point implements Comparable<Point> {
        int x, y, dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point p) {
            if (this.dist == p.dist) {
                if (this.x == p.x) {
                    return Integer.compare(this.y, p.y);
                }else{
                    return Integer.compare(this.x, p.x);
                }
            } else{
                return Integer.compare(this.dist, p.dist);
            }
        }
    }
}
