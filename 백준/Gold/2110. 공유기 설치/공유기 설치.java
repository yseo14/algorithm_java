import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static int[] house;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int low = 1;
        int high = house[n - 1] - house[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (installed(mid) < c) {   //  설치할 수 있는 공유기 수가 가지고 있는 공유기 수보다 작으면
                high = mid; //  거리를 줄여서 설치를 더 많이 할 수 있도록 함.
            }else{  //  설치할 수 있는 공유기 수가 가지고 있는 공유기 수보다 많거나 같으면
                low = mid + 1; //  거리를 늘려서 설치 할 수 있는 공유기 수를 줄인다.
            }
        }

        System.out.println(low - 1);
    }

    public static int installed(int dist) {
        int cnt = 1;
        int prev = house[0];

        for (int i = 1; i < n; i++) {
            int curr = house[i];
            if (curr - prev >= dist) {
                cnt += 1;
                prev = curr;
            }
        }
        return cnt;
    }
}
