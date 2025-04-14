import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;
        
        for(int i = 0;i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
            maxX = Math.max(sizes[i][0], maxX);
            maxY = Math.max(sizes[i][1], maxY);
        }
        
        return maxX*maxY;
    }
}