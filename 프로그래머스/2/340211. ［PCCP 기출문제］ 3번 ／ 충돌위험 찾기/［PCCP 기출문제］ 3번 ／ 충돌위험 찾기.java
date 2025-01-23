import java.io.*;
import java.util.*;

class Solution {
    static int size;
    static Queue<int[]>[] records;
    static int answer = 0;
    public int solution(int[][] points, int[][] routes) {
        
        size = routes.length;
        records = new LinkedList[size];
        for(int i = 0; i < size; i++){
            records[i] = new LinkedList<>();
        }
        
        recordRoute(points, routes);
        findCollision();
        
        return answer;
    }
    
    public static void findCollision() {
        int escapeRobots = 0;
        while(escapeRobots != size) { 
            int[][] map = new int[101][101];
            escapeRobots = 0;
            for(int i = 0; i < size; i++) {
                if(records[i].isEmpty()) { 
                    escapeRobots ++;
                    continue;
                }
                int[] temp = records[i].poll();
                map[temp[0]][temp[1]]++;
            }
            
            for(int i = 0;i < 101; i++) {
                for(int j = 0; j < 101; j++) {
                    if(map[i][j] > 1) {
                        answer ++;
                    }
                }
            }
        }
    }
    
    public static void recordRoute(int[][] points, int[][] routes) {
        for(int i = 0; i < size; i++) {
            int from = routes[i][0] - 1;
            int fromR = points[from][0] - 1;
            int fromC = points[from][1] - 1;
            
            records[i].add(new int[]{fromR, fromC});
            
            for(int j = 1; j < routes[i].length; j++) {
                int to = routes[i][j] - 1;
                int toR = points[to][0] - 1;
                int toC = points[to][1] - 1;
                
                while(fromR != toR) {
                    if(fromR < toR) {
                        fromR++;
                    } else {
                        fromR--;
                    }
                    records[i].add(new int[]{fromR, fromC});
                }
                
                while(fromC != toC) {
                    if(fromC < toC) {
                        fromC++;
                    } else {
                        fromC--;
                    }
                    records[i].add(new int[]{fromR, fromC});
                }
            }
        }
    }
}