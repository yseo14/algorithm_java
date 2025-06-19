import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] switches;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        switches = new boolean[n + 1]; // 인덱스 1 ~ n 사용

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = st.nextToken().equals("1");
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                toggleByBoy(num);
            } else {
                toggleByGirl(num);
            }
        }

        printSwitches();
    }

    public static void toggleByBoy(int num) {
        for (int i = num; i <= n; i += num) {
            switches[i] = !switches[i];
        }
    }

    public static void toggleByGirl(int num) {
        switches[num] = !switches[num];

        int i = 1;
        while (num - i >= 1 && num + i <= n && switches[num - i] == switches[num + i]) {
            switches[num - i] = !switches[num - i];
            switches[num + i] = !switches[num + i];
            i++;
        }
    }

    public static void printSwitches() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(switches[i] ? "1" : "0").append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }
}
