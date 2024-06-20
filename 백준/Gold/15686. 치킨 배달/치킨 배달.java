
import java.io.*;
import java.util.*;

/**
 * 치킨 배달
 * 치킨집과 일반집을 각각 리스트에 저장
 * 치킨집에서 M개를 뽑아서 주변 집과의 거리 계산
 * 치킨집과 일반집 사이 거리는 BFS로 계산 -> x
 * <p>
 * 치킨집 리스트에서 M개를 고르고, 일반집이랑 각각 거리 계산
 * -> 치킨집을 고를 때 "조합" 사용
 * 조합 자체가 백트래킹을 사용해서 구현하더라..
 * 
 * 치킨집을 다 골랐을 때, 각각의 일반집에서 각각의 치킨집까지 거리를 구하고 최소값을 도시의 치킨 거리에 더함. 
 * 그 값을 result에 저장하고, 다음 조합에서의 값과 비교할 수 있도록해서 최소의 치킨 거리를 구한다.
 */

public class Main {

    static List<Point> chicken;
    static List<Point> house;
    static List<Point> choice;
    static int[][] map;
    static boolean[] visited;
    static int N, M;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        chicken = new ArrayList<>();
        house = new ArrayList<>();
        choice = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) house.add(new Point(i, j));
                if (map[i][j] == 2) chicken.add(new Point(i, j));

            }
        }
        visited = new boolean[chicken.size()];
        backtracking(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }


    public static void backtracking(int start, int count) {
        if (count == M) {   // M개의 치킨집을 다 골랐을 때 수행할 부분
            int city_distance = 0;
            for (Point h : house) {
                int min = Integer.MAX_VALUE;
                for (Point c : choice) {
                    int distance = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                    min = Math.min(min, distance);
                }
                city_distance += min;
            }
            result = Math.min(city_distance, result);
            return;
        }

        //  반복문을 돌면서 치킨집을 choice 리스트에 넣는다.
        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice.add(chicken.get(i));
                backtracking(i + 1, count + 1);
                choice.remove(chicken.get(i));  //  다른 치킨집으로 채워야하니까 비워준다.
                visited[i] = false; //  다른 조합을 짜야할때 앞에서 사용한 치킨집들을 써야되니까 다시 false로 바꿔준다.
            }
        }
    }


    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
