import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>(); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        
        int count = 0;
        while(!pq.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    pq.poll();
                    count++;
                    if(i == location) {
                        return count;
                    }
                }
            }
            
        }
        return count;
       
    }
}
