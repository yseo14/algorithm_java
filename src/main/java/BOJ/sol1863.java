package BOJ;

import java.io.*;
import java.util.*;

public class sol1863 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        HashSet<Integer> buildings = new HashSet<>();

        int prev = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            if (prev != height) {
                if (prev < height) {
                    count++;
                    buildings.add(height);
                } else {
                    Iterator<Integer> it = buildings.iterator();
                    while (it.hasNext()) {
                        int b = it.next();
                        if (b > height) {
                            it.remove(); // 💡 안전하게 제거
                        }
                    }
                    if (!buildings.contains(height) && height != 0) {
                        count++;
                        buildings.add(height);
                    }
                }
                prev = height;
            }
        }
        System.out.println(count);
    }
}
