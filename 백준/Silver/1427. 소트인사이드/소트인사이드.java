import java.io.*;
import java.util.*;

public class Main {
    static String n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = br.readLine();

        int len = n.length();
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

}

