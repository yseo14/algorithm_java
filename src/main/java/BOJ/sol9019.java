package BOJ;

import java.io.*;
import java.util.*;

public class sol9019 {
    static int t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            visited[a] = true;

            Queue<Register> q = new LinkedList<>();
            q.add(new Register(a, ""));

            while (!q.isEmpty()) {
                Register curr = q.poll();
                if (curr.num == b) {
                    sb.append(curr.cmd).append("\n");
                    break;
                }

                if (!visited[curr.D()]) {
                    q.add(new Register(curr.D(), curr.cmd + "D"));
                    visited[curr.D()] = true;
                }
                if (!visited[curr.S()]) {
                    q.add(new Register(curr.S(), curr.cmd + "S"));
                    visited[curr.S()] = true;
                }
                if (!visited[curr.L()]) {
                    q.add(new Register(curr.L(), curr.cmd + "L"));
                    visited[curr.L()] = true;
                }
                if (!visited[curr.R()]) {
                    q.add(new Register(curr.R(), curr.cmd + "R"));
                    visited[curr.R()] = true;
                }
            }
        }
        System.out.println(sb);

    }

    public static class Register {
        int num;
        String cmd;

        public Register(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }

        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return num % 1000 * 10 + num / 1000;
        }

        int R() {
            return num % 10 * 1000 + num / 10;
        }
    }
}
