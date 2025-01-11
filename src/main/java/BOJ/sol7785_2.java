package BOJ;

import java.io.*;
import java.util.*;

public class sol7785_2 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> record = new HashMap<>();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String check = st.nextToken();
            record.put(name, check);
        }

        ArrayList<String> nameList = new ArrayList<>(record.keySet());
        nameList.sort(Comparator.reverseOrder());

        for (int i = 0; i < nameList.size(); i++) {
            if (record.get(nameList.get(i)).equals("enter")) {
                sb.append(nameList.get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
