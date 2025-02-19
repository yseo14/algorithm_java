import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int currSize = 2;
    static Queue<Point> q = new LinkedList<>();
    static PriorityQueue<Point> pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

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
        pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] > currSize || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, now.dist + 1));
                if (map[nx][ny] != 0 && map[nx][ny] < currSize) {
                    pq.offer(new Point(nx, ny, now.dist + 1));
                }
            }
        }
    }

    public static class Point implements Comparable<Point> {
        int x, y;
        int dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point p) {
            if (this.dist != p.dist) {  //  거리가 다르면
                return Integer.compare(this.dist, p.dist);  //  거리가 더 가까운 것을 우선순위
            }else{  //  거리가 같으면
                if (this.x == p.x) {    // 높이가 같은 곳에 있으면
                    return Integer.compare(this.y, p.y);    //  더 왼쪽에 있는게 우선순위
                }else{  //  높이가 다르면
                    return Integer.compare(this.x, p.x);    //  더 위쪽에 있는게 우선순위
                }
            }
        }
    }
}
