import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ArrayList<Coord> list = new ArrayList<>();
        int totalDist = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Coord(x, y));
            if (i == 0) {
                continue;
            }
            Coord prev = list.get(i - 1);
            totalDist += Math.abs(prev.x - x) + Math.abs(prev.y - y);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            Coord prev = list.get(i - 1);
            Coord now = list.get(i);
            Coord next = list.get(i + 1);

            int dist = totalDist - (Math.abs(now.x - prev.x) + Math.abs(now.y - prev.y) + Math.abs(now.x - next.x)
                    + Math.abs(now.y - next.y)) + Math.abs(next.x - prev.x) + Math.abs(next.y - prev.y);
            min = Math.min(min, dist);
        }

        System.out.println(min);
    }

    public static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
