import java.io.*;
import java.util.*;

public class Main {
    static int t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String sub = input.substring(1, input.length() - 1);

            Deque<String> dq = new LinkedList<>();
            if (n > 0) {
                StringTokenizer st = new StringTokenizer(sub, ",");
                for (int i = 0; i < n; i++) {
                    dq.add(st.nextToken());
                }
            }

            boolean isReverse = false;
            boolean isError = false;

            for (int i = 0; i < cmd.length(); i++) {
                char c = cmd.charAt(i);
                if (c == 'R') {
                    isReverse = !isReverse;
                } else if (c == 'D') {
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isReverse) {
                            dq.pollLast();
                        } else {
                            dq.pollFirst();
                        }
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                List<String> result = new ArrayList<>();
                while (!dq.isEmpty()) {
                    result.add(isReverse ? dq.pollLast() : dq.pollFirst());
                }
                sb.append(String.join(",", result)).append("]\n");
            }
        }
        System.out.print(sb);
    }
}
