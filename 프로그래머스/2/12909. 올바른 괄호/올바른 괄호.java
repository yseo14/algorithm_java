import java.io.*;
import java.util.*;


class Solution {
    boolean solution(String s) throws Exception {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            Character next = s.charAt(i);
            
            if(next == '(') {
                stack.push(next);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}