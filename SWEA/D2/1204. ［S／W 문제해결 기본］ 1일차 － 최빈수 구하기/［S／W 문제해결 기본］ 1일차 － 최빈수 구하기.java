import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int tc = Integer.parseInt(br.readLine());
            int[] score = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int num = Integer.parseInt(st.nextToken());
                score[num]++;
            }

            int maxFreq = 0;
            int maxScore = 0;

            for (int i = 1; i <= 100; i++) {
                if (score[i] >= maxFreq) {
                    maxFreq = score[i];
                    maxScore = i;
                }
            }
            sb.append("#" + test_case + " ");
            sb.append(maxScore+"\n");
        }
        System.out.println(sb);
    }
}