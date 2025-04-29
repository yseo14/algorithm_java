import java.io.*;

public class Main {
    static String w;
    static int t, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            w = br.readLine();
            k = Integer.parseInt(br.readLine());
            if (k == 1) {
                sb.append("1 1").append("\n");
                continue;
            }
            int[] alpha = new int[26];
            for (int i = 0; i < w.length(); i++) {  //  알파벳 개수 카운트
                alpha[w.charAt(i) - 97]++;
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < w.length(); i++) {
                char curr = w.charAt(i);
                if (alpha[curr - 97] < k) {
                    continue;
                }
                int count = 1;
                for (int j = i + 1; j < w.length(); j++) {
                    if (curr == w.charAt(j)) {
                        count++;
                        if (count == k) {
                            int len = j - i + 1;
                            max = Math.max(max, len);
                            min = Math.min(min, len);
                            break;
                        }
                    }
                }
            }
            if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
                sb.append("-1");
            } else {
                sb.append(min).append(" ").append(max);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}

