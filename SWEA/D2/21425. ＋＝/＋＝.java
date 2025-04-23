import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            int cnt = 0;
            while (a <= n && b <= n) {
             	if (a < b) a += b;
                else b += a;
                cnt++;
            }

            bw.write(cnt + "\n");
		}

        bw.flush();
        bw.close();
	}
}
