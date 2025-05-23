import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			String e = br.readLine();

			while (s.length() < e.length()) {
				if (e.charAt(e.length() - 1) == 'X') {
					e = e.substring(0, e.length() - 1);
				}else {
					e = e.substring(0, e.length() - 1);
					e = new StringBuilder(e).reverse().toString();
				}
			}
            sb.append("#"+test_case +" ");
			if(s.equals(e)) {
				sb.append("Yes").append("\n");
			}else {
				sb.append("No").append("\n");
			}
		}
        System.out.println(sb);
	}
}
