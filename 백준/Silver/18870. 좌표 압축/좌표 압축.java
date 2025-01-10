import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] origin;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        origin = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        temp = Arrays.stream(origin)
                .distinct()
                .sorted()
                .toArray();

        for (int i = 0; i < n; i++) {
            int result = binarySearch(origin[i], 0, temp.length - 1);
            sb.append(result).append(" ");
        }

        System.out.println(sb);

    }

    public static int binarySearch(int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (temp[mid] > target) {
                right = mid - 1;
            } else if (temp[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
