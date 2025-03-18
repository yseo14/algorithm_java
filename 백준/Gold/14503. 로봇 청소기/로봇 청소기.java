import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int result = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        Node curr = new Node(x, y, dir);
        q.add(curr);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(result);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (map[curr.x][curr.y] == 0) { //  현재 칸이 청소되지 않았으면
                map[curr.x][curr.y] = -1;
                result++;
            }
            boolean isExist = false;
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 0) { //  아직 청소되지 않은 곳이 있는지 확인
                    isExist = true;
                    break;
                }
            }
            if (isExist) {  //  아직 청소되지 않는 곳이 있으면
                int dir = curr.dir;
                while (true) {
                    dir = (dir + 3) % 4;   //  90도 회전
                    Node next = moveForward(new Node(curr.x, curr.y, dir));
                    if (map[next.x][next.y] == 0) {
                        q.add(next);
                        break;
                    }
                }
            } else {    //  없으면
                Node next = moveBackward(new Node(curr.x, curr.y, curr.dir));
                if (map[next.x][next.y] == 1) {
                    //  벽일 때
                    return;
                } else {
                    q.add(next);
                }
            }
        }
    }

    public static Node moveForward(Node curr) {
        int nx = curr.x;
        int ny = curr.y;
        if (curr.dir == 0) {
            nx -= 1;
        } else if (curr.dir == 1) {
            ny += 1;
        } else if (curr.dir == 2) {
            nx += 1;
        } else {
            ny -= 1;
        }
        return new Node(nx, ny, curr.dir);
    }

    public static Node moveBackward(Node curr) {
        int nx = curr.x;
        int ny = curr.y;
        if (curr.dir == 0) {
            nx += 1;
        } else if (curr.dir == 1) {
            ny -= 1;
        } else if (curr.dir == 2) {
            nx -= 1;
        } else {
            ny += 1;
        }
        return new Node(nx, ny, curr.dir);
    }

    static class Node {
        int x, y;
        int dir;

        Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
