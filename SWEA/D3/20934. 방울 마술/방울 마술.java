import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cups = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			int bub = 0;
			for (int i = 0; i < 3; i++) {
				if (cups.charAt(i) == 'o') {
					bub = i;
				}
			}

			while (count-- > 0) {
				if(bub == 0) {
					bub = 1;
				}else if(bub == 1) {
					bub = 0;
				}else {
					bub = 1;
				}
			}
			sb.append("#"+test_case+" ");
			sb.append(bub+"\n");

		}
		System.out.println(sb);
	}

}