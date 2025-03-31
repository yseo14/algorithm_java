import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < arr.length; i ++){
            if(i== 0){
                stack.push(arr[i]);
            }else{
                int before = stack.peek();
                if(before == arr[i]){
                    continue;
                }else{
                    stack.push(arr[i]);
                }
            }
        }
        int[] answer = new int[stack.size()];
        for(int i = 0;i<stack.size();i++){
            answer[i] = stack.get(i);
        }
        return answer;
    }
}