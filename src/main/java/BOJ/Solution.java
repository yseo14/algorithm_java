package BOJ;

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String[] players = new String[n + 1];
            int[] preferA = new int[n + 1];
            int[] preferB = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                preferA[i] = Integer.parseInt(br.readLine());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                preferB[i] = Integer.parseInt(br.readLine());
            }

            int idxA = 0;
            int idxB = 0;
            for (int i = 1; i <= n; i++) {
                while (players[preferA[idxA]] != null && idxA <= n) {
                    idxA++;
                }
                players[preferA[idxA]] = "A";

                while (players[preferB[idxB]] != null && idxB <= n) {
                    idxB++;
                }
                players[preferB[idxB]] = "B";
            }

        }
    }
}