import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static List<String> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            list = new LinkedList<>();
            dfs("1", 1, 1, 1, 0);
            Collections.sort(list);
            for (String str : list) {
                sb.append(str).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(String exp, int curr, int num, int sign, int result) {
        if (curr == n) {
            result += sign * num;
            if (result == 0) {
                list.add(exp);
            }
            return;
        }

        dfs(exp + "+" + (curr + 1), curr + 1, curr + 1, 1, result + (num * sign));
        dfs(exp + "-" + (curr + 1), curr + 1, curr + 1, -1, result + (num * sign));
        dfs(exp + " " + (curr + 1), curr + 1, num * 10 + (curr + 1), sign, result);
    }
}
