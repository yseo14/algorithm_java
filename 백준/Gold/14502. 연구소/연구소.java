
import java.io.*;
import java.util.*;

/**
 * 안전 구역의 크기를 구해라..
 * 벽을 세울 위치를 선택하는 경우는 조합으로 선택 후 해당 map2를 선택한 벽을 세워서 초기화
 * -> 조합으로 선택하는게 최적일까..?
 * map2에서 bfs or dfs로 바이러스 채움
 * 그리고 안전구역 크기 구해서 값 저장
 * 다음 조합에서 계산한 안전구역 크기랑 비교해서 결과 도출
 */

public class Main {

    static int[][] originMap;
    static int[][] afterMap;
    static int WALL_COUNT = 3;
    static int N, M;
    static List<Point> virus;   // 바이러스 좌표
    static List<Point> empty;   // 벽이 될 수 있는 좌표
    static List<Point> choice;   // 선택된 벽의 조합
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int result = Integer.MIN_VALUE;
    static boolean[] wall_visited;
    static boolean[][] virus_visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originMap = new int[N][M];
        virus = new ArrayList<>();
        empty = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
                if (originMap[i][j] == 2) virus.add(new Point(i, j));
                if (originMap[i][j] == 0) empty.add(new Point(i, j));
            }
        }
        wall_visited = new boolean[empty.size()];
        choice = new ArrayList<>();

        func(0, 0);
        System.out.println(result);
    }

    public static void func(int start, int count) {
        if (count == WALL_COUNT) {
            //  조합으로 선택된 벽을 세워서 map을 재구성
//            afterMap = originMap;     -> 이런식으로 map을 복제하면 안됨. originMap도 변경될 수 있음
            afterMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    afterMap[i][j] = originMap[i][j];
                }
            }

            for (Point c : choice) afterMap[c.x][c.y] = 1;

            //  모든 바이러스의 위치에서 그래프 탐색을 통해 바이러스가 최대한 퍼져나가도록 함
            virus_visited = new boolean[N][M];
            for (Point v : virus) {
                bfs(v, virus_visited);
            }

            int safety = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (afterMap[i][j] == 0) safety += 1;
                }
            }
            result = Math.max(result, safety);
            return;
        }

        //  조합을 통해 벽을 세울 위치를 구성
        for (int i = start; i < empty.size(); i++) {
            if (!wall_visited[i]) {
                wall_visited[i] = true;
                choice.add(empty.get(i));
                func(i + 1, count + 1);
                choice.remove(empty.get(i));
                wall_visited[i] = false;
            }
        }
    }

    public static void bfs(Point point, boolean[][] virus_visited) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        virus_visited[point.x][point.y] = true;

        while (!q.isEmpty()) {
            Point start = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = start.x + dx[i];
                int newY = start.y + dy[i];

                if ((newX >= 0 && newX < N) && (newY >= 0 && newY < M)) {   //  바이러스의 범위 체크
                    if (afterMap[newX][newY] == 0 && !virus_visited[newX][newY]) {
                        q.add(new Point(newX, newY));
                        virus_visited[newX][newY] = true;
                        afterMap[newX][newY] = 2;
                    }
                }
            }

        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
