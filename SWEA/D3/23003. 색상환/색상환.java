import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
        map.put("red", 1);
        map.put("orange", 2);
        map.put("yellow", 3);
        map.put("green", 4);
        map.put("blue", 5);
        map.put("purple", 6);
        
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            int val1 = map.get(first);
            int val2 = map.get(second);
            
            if(val1 == val2) {
                sb.append("E");
            } else if(Math.abs(val1 - val2) == 1 ||Math.abs(val1 - val2) == 5 ) {
                sb.append("A");
            } else if(Math.abs(val1 - val2) == 3) {
                sb.append("C");
            } else {
                sb.append("X");
            }
            sb.append("\n");
		}
        System.out.print(sb);
	}
}