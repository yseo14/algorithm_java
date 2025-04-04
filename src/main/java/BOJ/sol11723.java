package BOJ;

import java.io.*;
import java.util.*;

public class sol11723 {
    static int m;
    static int s = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        m = Integer.parseInt(br.readLine());

        while (m > 0) {
            m--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num;
            if (cmd.equals("add")) {
                num = Integer.parseInt(st.nextToken()) - 1;
                s |= (1 << num);    //  추가(비트 on)
            } else if (cmd.equals("remove")) {
                num = Integer.parseInt(st.nextToken()) - 1;
                s &= ~(1 << num);   //  삭제(비트 off)
            } else if (cmd.equals("check")) {
                num = Integer.parseInt(st.nextToken()) - 1;
                bw.write((s & (1 << num)) != 0 ? "1" : "0");
                bw.newLine();
            } else if (cmd.equals("toggle")) {
                num = Integer.parseInt(st.nextToken()) - 1;
                s ^= (1 << num);
            } else if (cmd.equals("all")) {
                for (int i = 0; i < 20; i++) {
                    s |= (1 << i);
                }
            } else if (cmd.equals("empty")) {
                s = 0;
            }
        }
        bw.flush();
        bw.close();
    }
}
