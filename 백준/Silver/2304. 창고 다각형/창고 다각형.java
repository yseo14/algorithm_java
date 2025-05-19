import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr = new int[1001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int left = 1001;
        int right = 0;
        int maxHeight = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            left = Math.min(left, l);
            right = Math.max(right, l);
            if (maxHeight < h) {
                maxIdx = l;
                maxHeight = h;
            }
        }

        int sum = maxHeight;
        int currHeight = arr[left];
        for (int i = left; i < maxIdx; i++) {
            if (arr[i] > currHeight) {
                currHeight = arr[i];
            }
            sum += currHeight;
        }

        currHeight = arr[right];
        for (int i = right; i > maxIdx; i--) {
            if (arr[i] > currHeight) {
                currHeight = arr[i];
            }
            sum += currHeight;
        }

        System.out.println(sum);
    }
}
