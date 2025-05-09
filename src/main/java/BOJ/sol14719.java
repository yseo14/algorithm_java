package BOJ;

import java.io.*;
import java.util.*;

public class sol14719 {
    static int h, w;
    static int[] blocks;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        blocks = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= w - 1; i++) {
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;

            int curr = blocks[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, blocks[j]);
            }
            for (int j = i + 1; j <= w - 1; j++) {
                rightMax = Math.max(rightMax, blocks[j]);
            }
            if( Math.min(leftMax, rightMax) < curr) continue;
            result += Math.min(leftMax, rightMax) - curr;
        }
        System.out.println(result);
    }
}
