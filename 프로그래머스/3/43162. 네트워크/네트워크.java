import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(i, n, computers);
                answer++;
            }
        }

        return answer;
    }
    
    public static void bfs(int start, int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = true;
        
            for(int i = 0; i < n; i++){
                if(!visited[i] && computers[curr][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public static void dfs(int start, int n, int[][] computers) {
        visited[start] = true;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && computers[start][i] == 1) {
                dfs(i, n, computers);
            }
        }
    }
}