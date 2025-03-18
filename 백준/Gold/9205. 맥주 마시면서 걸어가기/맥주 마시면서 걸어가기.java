import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static Node start, end;
    static ArrayList<Node> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t > 0) {
            list = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    start = new Node(x, y);
                } else if (i == n + 1) {
                    end = new Node(x, y);
                } else {
                    list.add(new Node(x, y));
                }
            }
            bfs();
            t--;
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(start);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (Math.abs(curr.x - end.x) + Math.abs(curr.y - end.y) <= 1000) {
                System.out.println("happy");
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    Node next = list.get(i);
                    if (Math.abs(curr.x - next.x) + Math.abs(curr.y - next.y) <= 1000) {
                        visited[i] = true;
                        q.add(next);
                    }
                }
            }
        }
        System.out.println("sad");
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
