package BOJ;

import java.io.*;
import java.util.*;

public class sol11729 {

    static int n;
    static int cnt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        bw.write((int) (Math.pow(2, n) - 1) + "\n");
        hanoi(n, 1, 2, 3);
        bw.flush();
        bw.close();

    }

    public static void hanoi(int n, int start, int temp, int goal) throws IOException {
        if (n == 1) {
            bw.write(start + " " + goal+"\n");
            return;
        }

        hanoi(n - 1, start, goal, temp);
        bw.write(start + " " + goal+"\n");
        hanoi(n - 1, temp, start, goal);
    }
}
