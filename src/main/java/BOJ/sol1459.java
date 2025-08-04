package BOJ;

import java.io.*;
import java.util.*;

public class sol1459 {
    static long x, y, w, s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        long case1, case2, case3;

        case1 = (x + y) * w;

        if ((x + y) % 2 == 0) {
            case2 = Math.max(x, y) * s;
        } else {
            case2 = (Math.max(x, y) - 1) * s + w;
        }

        case3 = Math.min(x, y) * s + (Math.max(x, y) - Math.min(x, y)) * w;

        System.out.println(Math.min(Math.min(case1, case2), case3));
    }
}
