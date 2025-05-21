package BOJ;

import java.io.*;
import java.util.*;

public class sol16234_2 {
    static int n, l, r;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                            continue;
                        }
                        int population = Math.abs(map[i][j] - map[nx][ny]);
                        if (population >= l && population <= r) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            result++;
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j]){
                        bfs(new Coord(i, j), visited);
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs(Coord start, boolean[][] visited) {
        Queue<Coord> q = new LinkedList<>();
        Queue<Coord> union = new LinkedList<>();
        q.add(start);
        union.add(start);
        visited[start.x][start.y] = true;

        int sum = 0;    //  연합의 인구 수 합
        int count = 0;  //  연합의 수
        while (!q.isEmpty()) {
            Coord curr = q.poll();
            sum += map[curr.x][curr.y];
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || !(Math.abs(map[curr.x][curr.y] - map[nx][ny]) >= l
                        && Math.abs(map[curr.x][curr.y] - map[nx][ny]) <= r)) {
                    continue;
                }
                q.add(new Coord(nx, ny));
                union.add(new Coord(nx, ny));
                visited[nx][ny] = true;
            }
        }

        int avg = sum / count;
        while (!union.isEmpty()) {
            Coord c = union.poll();
            map[c.x][c.y] = avg;
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
