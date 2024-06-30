package BOJ;

import java.io.*;
import java.util.*;

/**
 * 방향 그래프임..
 * 최단거리 -> BFS
 * 인접리스트로 풀까
 * 가중치가 있으니 인접행렬로 푸는게 나을 듯 - x
 * 인접리스트로 풀자. 더 활용성이 좋은 거 같음
 * <p>
 * 두 정점 사이에 여러 개의 간선이 존재할 수도 있다..
 * -> min 값으로 저장해주면 될 듯
 * 시작점에 해당하는 리스트에 그 시작점에서 뻗어나가는 간선의 정보(도착지, 가중치)를 넣는다
 */

public class sol1753 {

    static int v, e, k;
    static List<Node>[] connections;
    static boolean[] checked;
    static int[] dist;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        connections = new ArrayList[v + 1];
        checked = new boolean[v + 1];
        dist = new int[v + 1];

        for (int i = 0; i < v + 1; i++) {
            connections[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e ; i++) {   // 노드 및 간선의 연결 정보 저장
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            connections[start].add(new Node(end, value));
        }

        StringBuilder sb = new StringBuilder();
        dij(k);

        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void dij(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            checked[curr.end] = true;
            for (Node node : connections[curr.end]) {
                if (!checked[node.end]) {
                    if (dist[node.end] > node.value + dist[curr.end]) {
                        dist[node.end] = node.value + dist[curr.end];
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }

    /**
     * 우선순위 큐 사용을 위해 Comparable 인터페이스를 구현하여 Node 클래스를 만든다.
     * PriorityQueue는 내부적으로 compareTo 메서드를 사용하여 객체들을 정렬한다.
     * compareTo 메서드를 오버라이드하여 객체의 순서를 지정할 수 있다.
     */
    public static class Node implements Comparable<Node> {

        int end, value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        /**
         * 현재 객체와 비교 대상 객체의 value를 비교하여 순서를 정의한다.
         * 해당 메서드가 음수를 반환하면 현재 객체가 비교 대상 객체보다 value 값이 작은 것이므로 비교 대상 객체보다 앞에 위치
         *            양수를 반환하면 비교 대상 객체보다 큰 것이므로 뒤에 위치
         *            같으면 순서 유지
         */
        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
