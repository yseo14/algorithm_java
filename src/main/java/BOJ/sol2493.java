package BOJ;

import java.io.*;
import java.util.*;

public class sol2493 {
    static int N;
    static Stack<Struct> origin = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (origin.isEmpty()) {
                sb.append("0 ");
                origin.push(new Struct(height, i + 1));
            } else {
                while (true) {
                    if (origin.isEmpty()) {
                        sb.append("0 ");
                        origin.push(new Struct(height, i + 1));
                        break;
                    }
                    Struct s = origin.peek();
                    if (s.height > height) {
                        sb.append(s.index).append(" ");
                        origin.push((new Struct(height, i + 1)));
                        break;
                    } else {
                        origin.pop();
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static class Struct {
        int height;
        int index;

        public Struct(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
