package BOJ;

import java.io.*;
import java.util.*;

public class sol16928 {
    static int n, m;
    static int[] board = new int[101];
    static int moveCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 100; i++) {    //  뱀이나 사다리가 없는 곳은 다른 곳으로 이동하지 않으므로 자기 자신으로 초기화
            board[i] = i;
        }

        //  사다리가 있는 곳은 자기자신이 아닌 이동할 위치의 값을 넣는다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        //  뱀도 마찬가지
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        bfs();
        System.out.println(moveCount);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int levelSize = q.size();   //  주사위를 한 번 던졌을 때 이동 가능한 경우의 수
            for (int i = 0; i < levelSize; i++) {
                int currPos = q.poll();
                if (currPos == 100) {   //  현재 위치가 100(마지막 칸)이라면 종료
                    return;
                }

                for (int dice = 1; dice <= 6; dice++) { //  주사위를 던져서 이동할 수 있는 만큼 반복문
                    int nextPos = currPos + dice;   //  이동할 다음 위치
                    if (nextPos > 100) {    //  다음 위치가 100을 넘어가면 이동 불가
                        continue;
                    }

                    /**
                     * 주사위를 굴려 이동한 칸(nextPos)에 뱀이나 사다리가 있으면,
                     * 해당 칸(board[nextPos])이 최종적으로 도착해야 할 위치가 된다.
                     * 따라서 실제 이동할 위치를 movePos로 갱신해준다.
                     */
                    int movePos = board[nextPos];

                    if (!visited[movePos]) {    //  다음 위치에 방문한적이 없다면
                        visited[movePos] = true;    //  방문처리
                        q.add(movePos);
                    }
                }
            }
            moveCount++;
        }
    }
}
