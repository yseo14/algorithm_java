import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] buildings = new int[n];
            for(int i = 0; i < n; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            
            int sum = 0;
            for(int i = 2; i < n - 2; i++) {
                int max = 0;
                for(int j = i - 2; j <= i+2; j++) {
                    if(j == i) continue;
                    max = Math.max(buildings[j], max);
                }
            	if(max <  buildings[i]) {
                    sum += (buildings[i] - max);
                }
            }
            
            System.out.println("#" + test_case + " " + sum );
        }
    }
}