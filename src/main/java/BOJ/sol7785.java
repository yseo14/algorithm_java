package BOJ;

import java.io.*;
import java.util.*;


public class sol7785 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> record = new HashSet<>();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String check = st.nextToken();
            if (check.equals("enter")) {
                record.add(name);
            } else if (check.equals("leave")) {
                record.remove(name);
            }
        }

        ArrayList<String> nameList = new ArrayList<>(record);
        Collections.sort(nameList);

        for (int i =nameList.size()-1; i >= 0; i--) {
            sb.append(nameList.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
