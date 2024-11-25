package BOJ;

import java.io.*;
import java.util.*;

/**
 * BFS로 풀이하는데, 처음부터 존재하는 익은 토마토들을 큐에 저장하고 시작
 */
public class sol7576_2 {
    static int[][] map;
    static Queue<Point> ripe = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = 0;
    static int M, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    ripe.add(new Point(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }
        System.out.println(result-1);

    }

    public static void bfs() {
        while(!ripe.isEmpty()){
            Point curr = ripe.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx >= 0 && ny >= 0 && ny < M && nx < N) {
                    if (map[nx][ny] == 0) {
                        ripe.add(new Point(nx, ny));
                        map[nx][ny] = map[curr.x][curr.y] + 1;
                    }
                }
            }
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }
}
