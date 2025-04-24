import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
               arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int max = arr[n-1];
            long sum = 0;
            for(int i = n - 2; i >=0; i--) {
                if(arr[i] < max) {
                    sum += (max - arr[i]);
                } else {
                    max = arr[i];
                }
            }
            System.out.println("#" + test_case + " " + sum);
		}
	}
}