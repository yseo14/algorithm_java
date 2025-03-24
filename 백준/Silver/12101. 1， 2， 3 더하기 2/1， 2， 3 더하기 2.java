import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static ArrayList<String>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 3];
        for (int i = 0; i < n + 3; i++) {
            list[i] = new ArrayList<>();
        }

        list[1].add("1");
        list[2].add("1+1");
        list[2].add("2");
        list[3].add("1+1+1");
        list[3].add("1+2");
        list[3].add("2+1");
        list[3].add("3");

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                for (String s : list[i - j]) {
                    list[i].add(s + "+" + j);
                }
            }
        }

        if (list[n].size() < k) {
            System.out.println(-1);
        }else{
            Collections.sort(list[n]);
            System.out.println(list[n].get(k - 1));
        }
    }
}
