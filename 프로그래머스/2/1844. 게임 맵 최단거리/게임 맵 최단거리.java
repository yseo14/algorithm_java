import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] cost;
    
    public int solution(int[][] maps) {
        bfs(maps);
        int n = maps.length;
        int m = maps[0].length;
        
        return (cost[n - 1][m - 1] == Integer.MAX_VALUE) ? -1 : cost[n - 1][m - 1];
    }
    
    public void bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        cost = new int[n][m]; 
        for(int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        
        Queue<Coord> q = new LinkedList<>();
        q.add(new Coord(0, 0));
        cost[0][0] = 1;
        
        while(!q.isEmpty()) {
            Coord curr = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maps[nx][ny] == 0 || cost[nx][ny] != Integer.MAX_VALUE) continue;
                
                cost[nx][ny] = cost[curr.x][curr.y] + 1;
                q.add(new Coord(nx, ny));
            }    
        }
    }
    
    public class Coord {
        int x, y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
