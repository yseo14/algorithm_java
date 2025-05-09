package BOJ;

import java.io.*;
import java.util.*;

public class sol12919 {
    static String S;
    static String T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        if (bfs()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean bfs() {
        Queue<String> q = new LinkedList<>();
        q.add(T);

        while (!q.isEmpty()) {
            String curr = q.poll();

            if (curr.length() < S.length()) {
                break;
            }

            if (curr.equals(S)) {
                return true;
            }

            if (curr.endsWith("A")) {
                q.add(removeA(curr));
            }
            if (curr.startsWith("B")) {
                q.add(reverseAndRemoveB(curr));
            }

        }
        return false;
    }

    public static String removeA(String origin) {
        StringBuilder sb = new StringBuilder(origin);
        return sb.deleteCharAt(origin.length() - 1).toString();
    }

    public static String reverseAndRemoveB(String origin) {
        StringBuilder sb = new StringBuilder(origin);
        return sb.reverse().deleteCharAt(origin.length() - 1).toString();
    }
}
