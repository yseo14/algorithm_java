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
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			int max = arr[k - 1];
			int min = arr[0];
			int answer = max - min;

			for (int i = 1; i <= n - k; i++) {
				min = arr[i];
				max = arr[i + k - 1];
				answer = Math.min(answer, max - min);
			}
			sb.append("#" + test_case + " ");
			sb.append(answer + "\n");
		}

		System.out.println(sb);
	}

}