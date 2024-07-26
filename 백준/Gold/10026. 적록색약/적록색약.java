
import java.io.*;

public class Main {
    static int n;
    static String s;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int normalCnt = 0;
    static int abnormalCnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    normalCnt++;
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    abnormalCnt++;
                }
            }
        }
        System.out.println(normalCnt + " " + abnormalCnt);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char start = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
                continue;
            }
            if (!visited[newX][newY] && arr[newX][newY] == start) {
                dfs(newX, newY);
            }
        }
    }
}
