package BOJ;

import java.io.*;
import java.util.*;


/**
 * 치킨집과 일반집의 위치를 리스트에 각각 저장
 */

public class sol15686_2 {

    static List<Point> chicken;
    static List<Point> house;
    static List<Point> choice;
    static boolean[] visited;
    static int[][] map;
    static int N, M;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        house = new ArrayList<>();
        chicken = new ArrayList<>();
        choice = new ArrayList<>();
        
        visited = new boolean[chicken.size()];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) house.add(new Point(i, j));
                if (map[i][j] == 2) chicken.add(new Point(i, j));
            }
        }

        backtracking(0, 0);

        System.out.println(result);

    }

    public static void backtracking(int start, int count) {
        if (count == M) {
            //M개 치킨집 골랐을 때 거리 계산 로직
            int city_distance = 0;
            for (Point h : house) {
                int min = Integer.MAX_VALUE;
                for (Point c : choice) {
                    int distance = Math.abs(c.x - h.x) + Math.abs(c.y - h.y);
                    min = Math.min(distance, min);
                }
                city_distance += min;
            }
            result = Math.min(result, city_distance);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice.add(chicken.get(i));
                backtracking(i + 1, count + 1);
                choice.remove(chicken.get(i));
                visited[i] = false;
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
