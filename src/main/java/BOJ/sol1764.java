package BOJ;

import java.io.*;
import java.util.*;

public class sol1764 {
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<String> listen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            listen.add(br.readLine());
        }

        List<String> listenSeen = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String seen = br.readLine();
            if (listen.contains(seen)) {
                listenSeen.add(seen);
            }
        }

        Collections.sort(listenSeen);
        System.out.println(listenSeen.size());
        for (String str : listenSeen) {
            System.out.println(str);
        }
    }
}
