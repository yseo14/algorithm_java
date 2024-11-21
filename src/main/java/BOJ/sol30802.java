package BOJ;

import java.io.*;
import java.util.*;

public class sol30802 {
    static int N, T, P;
    static int tBundle = 0;
    static int pBundle = 0;
    static int pEach = 0;
    static ArrayList<Integer> sizeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            sizeList.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int i : sizeList) {
            if (i % T > 0) {    //나머지가 있으면
                tBundle += (i / T + 1);
            } else {
                tBundle += i / T;
            }
        }
        pBundle = N / P;
        pEach = N % P;
        System.out.println(tBundle);
        System.out.println(pBundle + " " + pEach);
    }
}
