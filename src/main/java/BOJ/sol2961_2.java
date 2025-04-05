package BOJ;

import java.io.*;
import java.util.*;

public class sol2961_2 {
    static int n;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Material> materials = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            materials.add(new Material(s, b));
        }
        int mask = 1 << n;
        for (int i = 1; i < mask; i++) {
            long sour = 1;
            long bitter = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  //  j번째 비트가 켜져있으면
                    sour *= materials.get(j).s;
                    bitter += materials.get(j).b;
                }
            }
            long val = Math.abs(sour - bitter);
            min = Math.min(val, min);
        }
        System.out.println(min);
    }

    public static class Material {
        long s, b;

        Material(long s, long b) {
            this.s = s;
            this.b = b;
        }
    }
}