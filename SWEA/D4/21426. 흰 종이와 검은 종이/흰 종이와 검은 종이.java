import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            long[][] rect = new long[3][4];
            StringTokenizer st;
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                rect[i][0] = Long.parseLong(st.nextToken());
                rect[i][1] = Long.parseLong(st.nextToken());
                rect[i][2] = Long.parseLong(st.nextToken());
                rect[i][3] = Long.parseLong(st.nextToken());
            }
            
            long white = (rect[0][2] - rect[0][0]) * (rect[0][3] - rect[0][1]);

            // 흰색과 검은색이 겹치는 영역들
            long inter1 = intersect(rect[0][0], rect[0][1], rect[0][2], rect[0][3],
                                   rect[1][0], rect[1][1], rect[1][2], rect[1][3]);
            long inter2 = intersect(rect[0][0], rect[0][1], rect[0][2], rect[0][3],
                                   rect[2][0], rect[2][1], rect[2][2], rect[2][3]);

            // 두 검은색 사각형이 흰색과 겹치는 부분이 중복될 경우 한번 뺴준다.
            long inter3 = intersect(
                Math.max(rect[0][0], rect[1][0]), Math.max(rect[0][1], rect[1][1]), Math.min(rect[0][2], rect[1][2]), Math.min(rect[0][3], rect[1][3]), 
                rect[2][0], rect[2][1], rect[2][2], rect[2][3]);

            if (white > (inter1 + inter2 - inter3)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static long intersect(long x1, long y1, long x2, long y2,
                                 long x3, long y3, long x4, long y4) {
        long nx1 = Math.max(x1, x3);
        long ny1 = Math.max(y1, y3);
        long nx2 = Math.min(x2, x4);
        long ny2 = Math.min(y2, y4);

        if (nx1 >= nx2 || ny1 >= ny2) return 0L;    // 겹치는 부분이 없음
        else return (nx2 - nx1) * (ny2 - ny1);
    } 
}
