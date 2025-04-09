import java.io.*;
import java.util.*;

public class Main {
    static int n, w, l;
    static int[] trucks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {   //  다리에 초기 값인 0을 모두 할당
            bridge.offer(0);
        }

        int passedTrucks = 0;
        int time = 0;
        int nextTruck = 0;  //  건널 차례인 트럭 인덱스
        int nextTruckWeight = 0;
        while (true) {
            if (passedTrucks == n) {
                break;
            }
            int passed = bridge.poll();  //  가장 앞에를 다리 밖으로 이동
            if (passed != 0) {  //  다리 밖으로 이동 값(트럭)이 0보다 크면, 트럭이 탈출한 것
                passedTrucks++;
            }

            if (nextTruck < n) {   //  모든 트럭이 다리를 건넜거나 건너는 중일 경우
                nextTruckWeight =trucks[nextTruck];
            }

            if (l - weightOnBridge(bridge) >= nextTruckWeight) {   //  다리 위 남은 무게가 다음 트럭보다 크면(다음 트럭이 다리에 올라갈 수 있으면)
                bridge.offer(nextTruckWeight);    //  다음 트럭을 다리 위로 이동
                nextTruck++;
            } else { //  다리 위 남은 무게가 다음 트럭보다 작으면(다음 트럭이 올라올 수 없음)
                bridge.offer(0);
            }
            time++;
        }

        System.out.println(time);
    }

    public static int weightOnBridge(Queue<Integer> bridge) {
        int sum = 0;
        for (int weight : bridge) {
            sum += weight;
        }
        return sum;
    }
}
