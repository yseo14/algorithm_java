import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l, r, c;
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) {
                return;
            }
            char[][][] building = new char[l][r][c];
            Coord start = null;
            Coord escape = null;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < c; k++) {
                        char tmp = input.charAt(k);
                        if (tmp == 'S') {
                            start = new Coord(i, j, k);
                        }
                        if (tmp == 'E') {
                            escape = new Coord(i, j, k);
                        }
                        building[i][j][k] = tmp;
                    }
                }
                br.readLine();
            }
            int[][][] result = bfs(building, start, l, r, c);
            if (result[escape.x][escape.y][escape.z] != 0) {
                System.out.println("Escaped in " + result[escape.x][escape.y][escape.z] + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }

        }
    }

    public static int[][][] bfs(char[][][] building, Coord start, int l, int r, int c) {
        int[][][] time = new int[l][r][c];
        Queue<Coord> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Coord curr = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                int nz = curr.z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r || nz >= c || building[nx][ny][nz] == '#'
                        || time[nx][ny][nz] != 0) {
                    continue;
                }
                time[nx][ny][nz] = time[curr.x][curr.y][curr.z] + 1;
                q.add(new Coord(nx, ny, nz));
            }
        }
        return time;
    }

    public static class Coord {
        int x, y, z;

        public Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
