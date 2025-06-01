import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
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

        List<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < m - 1; i++) {
            int from = list.get(i);
            int to = list.get(i + 1);
            if (find(from) != find(to)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

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

    public static int find(int n) {
        if (parent[n] == n) {
            return parent[n];
        }
        return find(parent[n]);
    }
}
