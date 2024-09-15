import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int x;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        visited = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            if (x <= arr[i]) continue;
            if (visited[x - arr[i]]) {
                count++;
            }
            visited[arr[i]] = true;
        }
        System.out.println(count);

    }
}
