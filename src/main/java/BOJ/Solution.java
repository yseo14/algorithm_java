package BOJ;

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] rect = new int[3][4];
            StringTokenizer st;
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                rect[i][0] = Integer.parseInt(st.nextToken());
                rect[i][1] = Integer.parseInt(st.nextToken());
                rect[i][2] = Integer.parseInt(st.nextToken());
                rect[i][3] = Integer.parseInt(st.nextToken());
            }

            //	흰색과 검은색이 겹치는 영역들
            int inter1 = intersect(rect[0][0], rect[0][1], rect[0][3], rect[0][4],
                    rect[1][0], rect[1][1], rect[1][3], rect[1][4]);
            int inter2 = intersect(rect[0][0], rect[0][1], rect[0][3], rect[0][4],
                    rect[2][0], rect[2][1], rect[2][3], rect[2][4]);

            //	두 검은색 사각형이 흰색과 겹치는 부분이 중복될 경우 한번 뺴준다.

        }
    }

    public static int intersect(int x1, int y1, int x2, int y2,
                                int x3, int y3, int x4, int y4) {
        int nx1 = Math.max(x1, x3);
        int ny1 = Math.max(y1, y3);
        int nx2 = Math.min(x2, x4);
        int ny2 = Math.min(y2, y4);

        if(nx1 > nx2 || ny1> ny2) return 0;	//	겹치는 부분이 없음
        else return (nx2 - nx1) * (ny2 - ny1);
    }
}