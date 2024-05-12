
import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Integer>> friend;
    static boolean[] visited;
    static int cnt;
    static int result;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        friend = new ArrayList<>();
        visited = new boolean[n];
        result = 0;

        for (int i = 0; i < n; i++) {
            friend.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            friend.get(x).add(y);
            friend.get(y).add(x);
        }


        for (int i = 0; i < n; i++) {
            cnt = 0;
            if (result != 1) {
                dfs(i, cnt);
            }
        }

        System.out.println(result);

    }

    public static void dfs(int start, int cnt) {
        if (cnt == 4) {
            result = 1;
            return;
        }

        visited[start] = true;
        int size = friend.get(start).size();
        for (int i = 0; i < size; i++) {
            int value = friend.get(start).get(i);
            if (!visited[value]) {
                dfs(value, cnt + 1);
            }
        }
        visited[start] = false;
    }

}

