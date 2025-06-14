package BOJ;

import java.io.*;
import java.util.*;

public class sol9935_2 {
    static String input;
    static String bomb;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        bomb = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            if (sb.length() >= bomb.length()) {
                if (isBomb()) {
                    explode();
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }

    public static boolean isBomb() {
        return sb.substring(sb.length() - bomb.length(), sb.length()).equals(bomb);
    }

    public static void explode() {
        sb = sb.delete(sb.length() - bomb.length(), sb.length());
    }
}
