package BOJ;

import java.io.*;
import java.util.*;

public class sol31403 {
    static int a, b, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        System.out.println(a + b - c);
        System.out.println(Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c);

    }
}
