package Softeer;

import java.io.*;
import java.util.*;

public class sol7628 {
    static int n;
    static int max = 0;
    static int count;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 2; i <= 100; i++){
            count = 0;
            int curr = i;
            for(int j = 0; j < n; j++){
                if(arr[j] % curr == 0){
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
