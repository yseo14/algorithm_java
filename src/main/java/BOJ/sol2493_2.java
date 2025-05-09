package BOJ;

import java.io.*;
import java.util.*;

public class sol2493_2 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Stack<Tower> towerStack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!towerStack.isEmpty() && towerStack.peek().height < height) {
                towerStack.pop();
            }
            if (towerStack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(towerStack.peek().idx).append(" ");
            }
            towerStack.push(new Tower(height, i + 1));
        }

        System.out.println(sb);

    }

    public static class Tower {
        int height;
        int idx;

        Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }
}
