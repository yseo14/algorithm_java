package BOJ;

import java.io.*;
import java.util.*;

public class sol1043 {
    static int n, m;
    static int[] parent;
    static List<List<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 사람 수
        m = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i; // 유니온파인드 초기화
        }

        // 진실을 아는 사람들 입력
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        if (truthCount == 0) {
            System.out.println(m);
            return;
        }
        List<Integer> truthList = new ArrayList<>();

        for (int i = 0; i < truthCount; i++) {
            truthList.add(Integer.parseInt(st.nextToken()));
        }

        // 파티별 참여자 입력 및 union 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            int first = -1;

            for (int j = 0; j < num; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);

                if (j == 0) {
                    first = person;
                } else {
                    union(first, person); // 같은 파티면 union
                }
            }
            parties.add(party);
        }

        // 진실을 아는 사람들끼리 union
        int base = truthList.get(0);
        for (int i = 1; i < truthList.size(); i++) {
            union(base, truthList.get(i));
        }

        // 진실 루트 확인
        int truthRoot = find(truthList.get(0));

        // 각 파티마다 거짓말 가능한지 확인
        int answer = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (find(person) == truthRoot) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 유니온 파인드 with path compression
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[py] = px;
        }
    }
}
