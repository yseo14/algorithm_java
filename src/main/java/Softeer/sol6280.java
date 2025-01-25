package Softeer;

import java.io.*;
import java.util.*;

public class sol6280 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(func(1, 2));
    }

    public static int func(int step, int num){
        int next = num + (num - 1);
        if(step == n){
            return next * next;
        } else {
            return func(step + 1, next);
        }
    }
}