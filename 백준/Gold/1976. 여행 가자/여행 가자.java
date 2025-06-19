import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int top = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            if (top != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b) {
        int n1 = find(a);
        int n2 = find(b);
        if (n1 < n2) {
            parent[n2] = n1;
        } else {
            parent[n1] = n2;
        }
    }

    public static int find(int n) {
        if (parent[n] == n) {
            return parent[n];
        }
        return find(parent[n]);
    }
}
