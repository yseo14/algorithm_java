package BOJ;

import java.io.*;
import java.util.*;

public class sol2178 {

    static int N, M;

    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();  //  String 문자열을 char형 배열로 바꿔준다.
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<point> q = new LinkedList<>();
        q.add(new point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            point start = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = start.x + dx[i];
                int newY = start.y + dy[i];

                if (newX >= 0 && newX < N) {
                    if (newY >= 0 && newY < M) {
                        if (maze[newX][newY] != 0 && !visited[newX][newY]) {
                            maze[newX][newY] = maze[start.x][start.y] + 1;
                            q.add(new point(newX, newY));
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
        }
    }

    static class point {
        int x;
        int y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
