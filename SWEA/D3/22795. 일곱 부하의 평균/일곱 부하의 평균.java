import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			int max = 0;
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 6; i++) {
            	int h = Integer.parseInt(st.nextToken());
                max = Math.max(h, max);
                sum += h;
            }
            
            int result  = max + 1;
            while((sum + result) % 7 != 0) {
                result+=1;
            }
            sb.append(result);
            sb.append("\n");
		}
        System.out.print(sb);
	}
}