import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int[] dx = { 0, 0, 1, -1 };
			int[] dy = { 1, -1, 0, 0 };

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			Queue<Coord> q = new LinkedList<>();
			int[][] time = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}
			q.add(new Coord(0, 0));
			time[0][0] = 0;
			int min = 0;
			while (!q.isEmpty()) {
				Coord curr = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = curr.x + dx[i];
					int ny = curr.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
						continue;
					}
					int nTime = time[curr.x][curr.y]+ map[nx][ny];
					if(nTime < time[nx][ny]) {
						 time[nx][ny] = nTime;
						q.add(new Coord(nx, ny));
					}
				}
			}
			sb.append("#" + test_case + " ");
			sb.append(time[n - 1][n - 1] + "\n");

		}

		System.out.println(sb);
	}

	public static class Coord {
		int x, y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}