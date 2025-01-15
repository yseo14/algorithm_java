import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] invited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        invited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < graph.get(1).size(); i++) {
            int friend = graph.get(1).get(i);
            invited[friend] = true;
            for (int j = 0; j < graph.get(friend).size(); j++) {
                int friend2 = graph.get(friend).get(j);
                invited[friend2] = true;
            }
        }

        invited[1] = false;

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (invited[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
