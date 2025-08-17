import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int l;
    static String[][] map;
    static String[] direction;
    static int dir = 0; //  0: 동, 1: 남, 2: 서, 3: 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Deque<Coord> snake = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new String[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], " ");
        }

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = "A";
        }

        direction = new String[10001];
        Arrays.fill(direction, " ");
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            direction[sec] = dir;
        }

        snake.addFirst(new Coord(1, 1));
        map[1][1] = "S";

        int time = 0;
        while (true) {
            Coord head = snake.peekFirst();
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];

            if (nx <= 0 || ny <= 0 || nx > n || ny > n || map[nx][ny].equals("S")) {
                System.out.println(time + 1);
                return;
            }

            snake.addFirst(new Coord(nx, ny));

            if (!map[nx][ny].equals("A")) {
                Coord tail = snake.pollLast();
                map[tail.x][tail.y] = " ";
            }
            map[nx][ny] = "S";

            time++;

            if (!direction[time].equals(" ")) {
                if (direction[time].equals("L")) {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                } else if (direction[time].equals("D")) {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                }
            }
        }
    }

    public static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

