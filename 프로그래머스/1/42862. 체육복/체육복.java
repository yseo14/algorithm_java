import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];
        Arrays.fill(students, 1);
        
        for(int i : reserve) {
            students[i] += 1;
        }
        for(int i : lost) {
            students[i] -= 1;
        }
        
        for(int i = 1; i <= n; i++) {
            if(students[i] == 0) {
                if(students[i - 1] == 2) {
                    students[i - 1] -= 1;
                    students[i] += 1;
                    continue;
                }
                if(i != n){
                    if(students[i + 1] == 2) {
                        students[i + 1] -= 1;
                        students[i] += 1;
                        continue;
                    }
                }
                
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i < n + 1; i++){
            if(students[i] > 0){
                answer += 1;
            }
        }
        
    
        return answer;
    }
}