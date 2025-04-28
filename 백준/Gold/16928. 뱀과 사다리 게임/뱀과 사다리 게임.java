import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] board = new int[101];
    static int moveCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        bfs();
        System.out.println(moveCount);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                int currPos = q.poll();

                if (currPos == 100) {
                    return;
                }

                for (int dice = 1; dice <= 6; dice++) {
                    int nextPos = currPos + dice;
                    if (nextPos > 100) {
                        continue;
                    }

                    int movePos = board[nextPos];

                    if (!visited[movePos]) {
                        visited[movePos] = true;
                        q.add(movePos);
                    }
                }
            }
            moveCount++;
        }
    }
}
