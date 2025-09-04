import java.io.*;
import java.util.*;

public class Main {
    static String origin;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine();

        for (int i = 0; i < origin.length(); i++) {
            for (int j = i + 1; j <= origin.length(); j++) {
                set.add(origin.substring(i, j));
            }
        }
        System.out.println(set.size());

    }
}
