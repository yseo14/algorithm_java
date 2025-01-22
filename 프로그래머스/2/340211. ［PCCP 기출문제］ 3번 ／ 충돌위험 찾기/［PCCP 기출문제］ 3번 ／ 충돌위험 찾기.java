import java.io.*;
import java.util.*;

/**
* 각 로봇이 지나가는 좌표를 배열에 저장한다. 
* 모든 배열을 비교하면서 충돌을 확인한다. 
* r좌표가 먼저 변한다 -> 위아래로 먼저 간다. 
*/
class Solution {
    static Queue<int[]>[] record;
    static int answer = 0;
    static int size;
    
    public int solution(int[][] points, int[][] routes) {
        size = routes.length;
        record = new LinkedList[size];
        for(int i = 0;i<size;i++){
            record[i] = new LinkedList<>();
        }
        recordRoute(points, routes);
        findCollision();

        return answer;
    }
    
    public static void findCollision() {
        int escapeRobots = 0;
        while(escapeRobots != size){
            int[][] map = new int[101][101];
            escapeRobots = 0;
            for(int i = 0; i < size; i++){  //  1초 지날 때마다
                if(record[i].isEmpty()){
                    escapeRobots++;
                    continue;
                }
                int[] temp = record[i].poll();
                map[temp[0]][temp[1]] ++;
            }
            for(int i = 0;i<101;i++){
                for(int j = 0;j<101;j++){
                    if(map[i][j]>1){
                        answer ++;
                    }
                }
            }
        }
        
    }
    
    public static void recordRoute(int[][] points, int[][] routes) {
        for(int i = 0; i < size; i++) {
            int from = routes[i][0] - 1;   //  출발 좌표 인덱스
            int fromR = points[from][0] -1;
            int fromC = points[from][1] -1;
            
            record[i].add(new int[]{fromR, fromC});    // 출발 좌표 기록
            
            for(int j = 1; j < routes[i].length; j++){
                int to = routes[i][j] - 1; //  도착 좌표 인덱스
                int toR = points[to][0]-1;
                int toC = points[to][1]-1;
            
                while(fromR != toR) {
                    if(fromR < toR) {
                        fromR++;
                    } else {
                        fromR--;
                    }
                    record[i].add(new int[]{fromR, fromC});    //  r좌표 이동할 때마다 기록
                }
            
                while(fromC != toC) {
                    if(fromC < toC) {
                        fromC++;
                    } else {
                        fromC--;
                    }
                    record[i].add(new int[]{fromR, fromC});    //  c좌표 이동할 때마다 기록, r좌표는 이미 도착지점의 r좌표가 되어있을 것
                }
            }
        }    
    }
}
