import java.io.*;
import java.util.*;

public class Main {
    static int n, w, l;
    static int[] trucks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());  // 트럭 수
        w = Integer.parseInt(st.nextToken());  // 다리 길이
        l = Integer.parseInt(st.nextToken());  // 다리 최대 하중

        trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.offer(0);  // 다리 초기화 (길이만큼 0 채움)
        }

        int time = 0;
        int nextTruck = 0;
        int bridgeWeight = 0;

        while (nextTruck < n) {
            time++;

            // 트럭 한 칸 이동 (맨 앞 나감)
            int passed = bridge.poll();
            bridgeWeight -= passed;

            int nextTruckWeight = trucks[nextTruck];
            if (bridgeWeight + nextTruckWeight <= l) {
                bridge.offer(nextTruckWeight);
                bridgeWeight += nextTruckWeight;
                nextTruck++;
            } else {
                bridge.offer(0);  // 올라가지 못하면 빈 공간
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 데 필요한 시간 추가
        time += w;

        System.out.println(time);
    }
}
