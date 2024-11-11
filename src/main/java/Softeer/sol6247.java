package Softeer;

import java.io.*;
import java.util.*;

public class sol6247 {
    static int n, q;
    static List<Integer> fuels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        fuels = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fuels.add(Integer.parseInt(st.nextToken()));
        }

        fuels.sort(null);
        for (int i = 0; i < q; i++) {
            int m = Integer.parseInt(br.readLine());
            System.out.println(func(m));
        }

    }

    public static int func(int m) {
        int index = Collections.binarySearch(fuels, m);
        if (index >= 0) {
            return index * ((n - 1) - index);
        } else {
            return 0;
        }
    }
}
