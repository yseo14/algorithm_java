package CodeTree;

import java.io.*;
import java.util.*;

/**
 * 블럭쌓는 명령
 */
public class sol5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] blocks = new int[N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int Ai = Integer.parseInt(st.nextToken());
            int Bi = Integer.parseInt(st.nextToken());

            blocks[Ai - 1]++;
            if (Bi < N) {
                blocks[Bi]--;
            }
        }

        int[] finalBlocks = new int[N];
        finalBlocks[0] = blocks[0];
        for (int i = 1; i < N; i++) {
            finalBlocks[i] = finalBlocks[i - 1] + blocks[i];
        }

        Arrays.sort(finalBlocks);

        int median = finalBlocks[N / 2];
        System.out.println(median);
    }
}