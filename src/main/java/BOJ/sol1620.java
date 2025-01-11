package BOJ;

import java.io.*;
import java.util.*;

public class sol1620 {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numName = new HashMap<>();
        HashMap<String, Integer> nameNum = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            numName.put(i, name);
            nameNum.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            if (q.charAt(0) >= 49 && q.charAt(0) <= 57) {
                int num = Integer.parseInt(q);
                sb.append(numName.get(num)).append("\n");
            } else {
                sb.append(nameNum.get(q)).append("\n");
            }
        }
        System.out.println(sb);

    }
}
