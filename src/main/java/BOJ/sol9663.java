package BOJ;

import java.io.*;
import java.util.*;

public class sol9663 {

    static int n;
    static int[] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n + 1; i ++){
            map = new int[n + 1];
            map[1] = i; //  (1,1) 부터 시작
            dfs(2);
        }

        System.out.println(count);

    }

    public static void dfs(int row){
        if (row > n) {
            count++;
        }

        else{
            for (int i = 1; i < n + 1; i++) {
                map[row] = i;   // 현재 check 할 위치. -> queen 을 놓을 자리
                if(check(row)){
                    dfs(row + 1);
                }
            }
        }


    }


    public static boolean check(int row) {
        for (int i = 1; i < row; i++) {
            if (map[i] == map[row]) return false;
            if (Math.abs(i - row) == Math.abs(map[i] - map[row])) return false;
        }
        return true;
    }
}
