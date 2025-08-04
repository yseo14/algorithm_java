package BOJ;

import java.io.*;
import java.util.*;

public class sol7662 {
    static int t;
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();

            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    minHeap.add(n);
                    maxHeap.add(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else if (cmd.equals("D")) {
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (n == 1) {
                        remove(maxHeap, map);
                    } else {
                        remove(minHeap, map);
                    }
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                int max = clean(maxHeap, map);
                int min = clean(minHeap, map);
                System.out.println(max + " " + min);
            }
        }
    }

    public static void remove(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int num = heap.poll();
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
                break;
            }
        }
    }

    public static int clean(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (map.containsKey(num)) {
                return num;
            }
            heap.poll();
        }
        return 0;
    }
}
