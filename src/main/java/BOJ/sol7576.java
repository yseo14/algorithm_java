package BOJ;

import java.io.*;
import java.util.*;

/**
 * 익은 토마토 옆에 있는 토마토는 하루가 지나면 익는다.
 * 토마토가 며칠이 지나면 모두 익게 되는가? -> 최소 일 수 (bfs)
 * 토마토가 모두 익지 못하면 -1
 * 토마토가 하나 이상 있음..
 * -> 여러 개의 토마토에서 동시에 퍼져나가기 시작할 텐데..
 * 큐에 시작 노드 하나만 넣고 시작하는게 아니라, 처음 토마토 위치들을 모두 저장하고 시작하면 되나?  - X 안됨
 * <p>
 * bfs 돌았을 때 0인 부분 있으면 -1, 없으면 count 출력, 처음부터 다 익었으면 0 출력
 * <p>
 * map을 1로 바꿔주는게 아니라 depth를 증가시킨다.
 * map을 하나 더 만든다.
 */


public class sol7576 {

    static int N, M;
    static int[][] map;
    static int[][] time;
    static Queue<Point> tomato;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        time = new int[N][M];
        tomato = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) tomato.add(new Point(i, j));
                if(map[i][j]==0) time[i][j] = -1;
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (time[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, time[i][j]);
            }
        }
        System.out.println(result);

    }

    public static void bfs() {

        while (!tomato.isEmpty()) {
            Point t = tomato.poll();
            for (int i = 0; i < 4; i++) {
                int newX = t.x + dx[i];
                int newY = t.y + dy[i];
                if ((newX >= 0 && newX < N) && (newY >= 0 && newY < M)) {
                    if (map[newX][newY] == 0 && time[newX][newY] == -1) {
                        tomato.add(new Point(newX, newY));
                        time[newX][newY] = time[t.x][t.y] + 1;
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
