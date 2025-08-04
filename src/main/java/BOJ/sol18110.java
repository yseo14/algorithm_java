package BOJ;

import java.io.*;
import java.util.*;

public class sol18110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(levels);

        int cut = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += levels[i];
        }

        int count = n - cut * 2;
        System.out.println(Math.round((double) sum / count));
    }
}
