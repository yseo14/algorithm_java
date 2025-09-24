import java.io.*;
import java.util.*;


class Solution {
    public String solution(String number, int k) throws Exception {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int count = number.length() - k;
        
        for(int i = 0; i < count; i++) {
            int max = 0;
            for(int j = start; j <= i + k; j++) {
                int curr = number.charAt(j) - '0';
                if(curr > max) {
                    max = curr;
                    start = j + 1;
                }
            }
            sb.append(String.valueOf(max));
        }
    
        
        return sb.toString();
    }
}