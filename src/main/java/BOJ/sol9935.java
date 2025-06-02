package BOJ;

import java.io.*;

public class sol9935 {
    static String origin;
    static String bomb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        origin = br.readLine();
        bomb = br.readLine();
        int bombLength = bomb.length();

        for (int i = 0; i < origin.length(); i++) {
            sb.append(origin.charAt(i));

            if (sb.length() >= bombLength) {
                boolean isBomb = true;
                for (int j = 0; j < bombLength; j++) {
                    if (bomb.charAt(j) != sb.charAt(sb.length() - bombLength + j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    sb.delete(sb.length() - bombLength, sb.length());
                }
            }

        }
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

    }
}
