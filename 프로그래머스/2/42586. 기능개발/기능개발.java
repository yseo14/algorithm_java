import java.io.*;
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) { 
            q.offer((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }
        System.out.println(q);
        int max = q.peek();
        int count = 0;
        while(true){
            if(q.isEmpty()){
                answer.add(count);
                return answer;
            }
            int next = q.peek();
            if(next > max){
                max = next;
                answer.add(count);
                count = 0;
                continue;
            }
            q.poll();
            count++;
        }
        
    }
}