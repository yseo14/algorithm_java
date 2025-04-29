import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            int sum = 0;
            for(int i  = 1; i <= n; i++) {
                if(sum + i == p) {
                    sum += i - 1;
                    continue;
                }
               	sum += i;
            }
            System.out.println(sum);
		}
	}
}