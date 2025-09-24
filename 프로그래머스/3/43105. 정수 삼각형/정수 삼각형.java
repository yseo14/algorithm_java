import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) throws Exception {
        int height = triangle.length;
        
        int[][] dp = new int[height][height];
        for(int i = 0; i < height; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < height; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for(int j = 1; j <= i; j ++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
        
        int answer = 0;
        for(int i = 0; i < height; i++) {
            answer = Math.max(dp[height - 1][i], answer);
        }
        
        return answer;
    }
}