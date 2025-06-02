package BOJ;

import java.io.*;
import java.util.*;

public class sol22233 {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashSet<String> memo = new HashSet<>();
        for (int i = 0; i < n; i++) {
            memo.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String used = br.readLine();
            String[] keywords = used.split(",");
            for (String keyword : keywords) {
                if (memo.contains(keyword)) {
                    memo.remove(keyword);
                }
            }
            sb.append(memo.size()).append("\n");
        }

        System.out.println(sb);
    }
}
