import java.io.*;
import java.util.*;

public class Main {
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
        dfs(materials, 0, 1L, 0L, false);
        System.out.println(min);
    }

    public static void dfs(ArrayList<Material> materials, int idx, long sumS, long sumB, boolean used) {
        if (used) {
            long currVal = Math.abs(sumS - sumB);
            min = Math.min(currVal, min);
        }

        if (idx == n) {
            return;
        }
        dfs(materials, idx + 1, materials.get(idx).s * sumS, materials.get(idx).b + sumB, true);
        dfs(materials, idx + 1,  sumS, sumB, false);
    }

    public static class Material {
        long s, b;

        Material(long s, long b) {
            this.s = s;
            this.b = b;
        }
    }
}
