import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int x = 0;
            int y = 0;
            int dir = 0;
            for (int i = 1; i <= n * n; i++) {
                arr[x][y] = i;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= n || ny >= n || nx < 0 || ny < 0 || arr[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                x = nx;
                y = ny;
            }

            sb.append("#" + test_case + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}