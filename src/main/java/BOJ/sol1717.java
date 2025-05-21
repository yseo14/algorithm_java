package BOJ;

import java.io.*;
import java.util.*;

public class sol1717 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) { //  union
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static int find(int num) {
        if (parent[num] == num) {
            return parent[num];
        }
        return find(parent[num]);
    }
}
