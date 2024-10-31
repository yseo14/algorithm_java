package Softeer;

import java.io.*;
import java.util.*;

public class sol6294 {

    static int N;
    static int K;
    static Double avg;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        scores = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Double result = getAvg(start, end);
            String formatted = String.format("%.2f", result);
            System.out.println(formatted);
        }
    }

    public static Double getAvg(int start, int end) {
        int startIdx = start - 1;
        int endIdx = end - 1;
        Double sum = 0.0;
        for (int i = startIdx; i <= endIdx; i++) {
            sum += scores[i];
        }
        Double avg = sum / (end - start + 1);
        return Double.parseDouble(String.valueOf(avg));
    }
}