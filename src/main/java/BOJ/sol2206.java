package BOJ;

import java.io.*;
import java.util.*;

public class sol2206 {
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int[][][] visited = new int[2][n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (true) {
            int[] node = q.poll();
            int w = node[0];
            int x = node[1];
            int y = node[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= n || nx < 0 || ny >= m || ny < 0) {
                    continue;
                }

                if (map[nx][ny] == 0) { //  다음 노드가 벽이 아닐 때
                    if (visited[w][nx][ny] == 0) {  //  처음 방문하는 곳일 경우
                        q.offer(new int[]{w, nx, ny});
                        visited[w][nx][ny] = visited[w][x][y] + 1;
                        if (nx == n - 1 && ny == m - 1) {   //  목적지 도달시
                            return visited[w][nx][ny];
                        }
                    }
                } else {    //  다음 노드가 벽일 때
                    if (w == 0) { //  아직 벽을 한 번도 부수지 않았다면
                        if (visited[1][nx][ny] == 0) {  //  처음 방문하는 곳일 경우
                            q.offer(new int[]{1, nx, ny});  //  벽을 부수고 방문
                            visited[1][nx][ny] = visited[0][x][y] + 1;  //  이전 노드(벽을 부수지 않고 왔을 때의 배열)까지 거리 + 1
                            if (nx == n - 1 && ny == m - 1) {   //  목적지 도달시
                                return visited[1][nx][ny];
                            }
                        }
                    }
                }
            }
            if (q.isEmpty()) {
                return -1;
            }
        }
    }
}
