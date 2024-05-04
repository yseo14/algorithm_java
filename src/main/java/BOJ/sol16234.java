package BOJ;

import java.io.*;
import java.util.*;


public class sol16234 {

    /**
     * TODO: bfs 돌리는데 현재 칸과 새로 접근하는 칸과의 차이가 l,r 사이면 open을 true로 바꾸고 sum에 값을 더하고, cnt ++
     */

    static int n, l, r;
    static int[][] land;
    static boolean[][] border;
    static int sum, cnt;
    static boolean endCheck;
    static int result = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Point> list;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        land = new int[n][n];
        border = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;

        while (true) {
            endCheck = true;
            border = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!border[i][j]) {
                        bfs(i, j);
                        if (list.size() > 1) {
                            updateLand(sum, cnt);
                            endCheck = false;
                        }
                    }
                }
            }
            if (endCheck) break;
            result++;
        }


        System.out.println(result);


    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        list = new ArrayList<>();
        q.add(new Point(x, y));
        list.add(new Point(x, y));

        border[x][y] = true;
        sum = land[x][y];
        cnt = 0;
        while (!q.isEmpty()) {
            Point curr = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];

                if ((newX >= 0 && newX < n) && (newY >= 0 && newY < n)) {
                    int diff = Math.abs(land[curr.x][curr.y] - land[newX][newY]);
                    if ((diff >= l && diff <= r) && !border[newX][newY]) {
                        sum += land[newX][newY];
                        q.add(new Point(newX, newY));
                        list.add(new Point(newX, newY));
                        border[newX][newY] = true;
                    }
                }
            }

//
//            for (int i = 0; i < n; i++) {
//                System.out.println();
//                for (int j = 0; j < n; j++) {
//                    System.out.print(land[i][j] + " ");
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                System.out.println();
//                for (int j = 0; j < n; j++) {
//                    System.out.print(border[i][j] + " ");
//                }
//            }
//            System.out.println();
//            System.out.println("sum: " + sum + ", cnt: " + cnt + " result: " + result);
//            System.out.println("======================");
        }


//        System.out.println();
//        System.out.println("*****************************************");
//        System.out.println("======================");
//        for (int i = 0; i < n; i++) {
//            System.out.println();
//            for (int j = 0; j < n; j++) {
//                System.out.print(land[i][j] + " ");
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println();
//            for (int j = 0; j < n; j++) {
//                System.out.print(border[i][j] + " ");
//            }
//        }
//        System.out.println();
//        System.out.println("sum: " + sum + ", cnt: " + cnt + " result: " + result);
//        System.out.println("======================");
//        System.out.println("*****************************************");

    }

    public static void updateLand(int sum, int cnt) {
        int avg = sum / cnt;
        for (Point p : list) {
            land[p.x][p.y] = avg;
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
