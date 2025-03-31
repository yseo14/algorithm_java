import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums){
            set.add(i);
        }
        
        int size = set.size();
        if(size>nums.length/2){
            answer = nums.length/2;
        }else{
            answer = size;
        }
        
        
        return answer;
    }
}