import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                if(num % 2 == 1) {
                	sum+=num;
                }
			}
            System.out.println("#"+ test_case + " " + sum);
	}
}
}