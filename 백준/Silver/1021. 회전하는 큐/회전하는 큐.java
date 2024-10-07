
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static LinkedList<Integer> deque = new LinkedList<>();
    static int result = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int targetIndex = deque.indexOf(arr[i]);
            int halfIndex;
            if (deque.size() % 2 == 0) {
                halfIndex = deque.size() / 2 - 1;
            } else halfIndex = deque.size() / 2;

            if (targetIndex <= halfIndex) {
                moveLeft(targetIndex);
                deque.pollFirst();
            } else {
                moveRight(deque.size() - targetIndex);
                deque.pollFirst();
            }
        }

        System.out.println(result);
    }

    public static void moveLeft(int n) {
        while (n > 0) {
            deque.addLast(deque.pollFirst());
            result++;
            n--;
        }
    }

    public static void moveRight(int n) {
        while (n > 0) {
            deque.addFirst(deque.pollLast());
            result++;
            n--;
        }
    }
}
