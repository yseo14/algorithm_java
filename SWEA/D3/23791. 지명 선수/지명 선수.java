import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String[] players = new String[n + 1];
            int[] preferA = new int[n + 1];
            int[] preferB = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                preferA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                preferB[i] = Integer.parseInt(st.nextToken());
            }

            int idxA = 1;
            int idxB = 1;
            for (int i = 1; i <= n; i++) {
                while (idxA <= n && players[preferA[idxA]] != null) {
                    idxA++;
                }
                if (idxA <= n)
                    players[preferA[idxA]] = "A";

                while (idxB <= n && players[preferB[idxB]] != null) {
                    idxB++;
                }
                if (idxB <= n)
                    players[preferB[idxB]] = "B";
            }
            for (int i = 1; i <= n; i++) {
                sb.append(players[i]);
            }
            sb.append("\n");
        }
		System.out.print(sb);            
    }
}