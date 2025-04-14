import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] sp1 = {1, 2, 3, 4, 5};
        int[] sp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] sp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int[3]; 
        for(int i = 0;i < answers.length; i++){
            if(sp1[i%5] == answers[i]) { 
                cnt[0]+=1;
            }
            if(sp2[i%8] == answers[i]) { 
                cnt[1]+=1;
            }
            if(sp3[i%10] == answers[i]) { 
                cnt[2]+=1;
            }
        }
        int max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<3;i++){
            if(cnt[i]==max){
                list.add(i+1);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}