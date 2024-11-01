package Softeer;

import java.io.*;
import java.util.*;

public class sol7703 {
    static int N;
    static String first, second;
    static String[] result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new String[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            first = st.nextToken();
            second = st.nextToken();
            String upperFirst = first.toUpperCase();
            int xIndex = upperFirst.indexOf("X");
            String upperSecond = second.toUpperCase();
            result[i] = String.valueOf(upperSecond.charAt(xIndex));
        }

        for(String s : result){
            System.out.print(s);
        }

    }
}
