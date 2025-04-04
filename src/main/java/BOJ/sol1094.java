package BOJ;

import java.io.*;

public class sol1094 {
    static int x;
    static int stickCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        int exp = 6;
        int sum = 0;
        while (true) {
            int currentStick = 1 << exp;    //  현재 막대의 길이
            if (sum + currentStick <= x) {  //  현재 막대를 사용할 수 있다.(이어 붙였을 때 x보다 작거나 같은 경우)
                sum += currentStick;
                stickCount++;
            } else {    // 현재 막대를 사용할 수 없으므로 반으로 자른다
                exp--;
            }

            if (sum == x) { //  이어 붙인 막대 총 길이가 x와 같으면
                break;
            }
        }
        System.out.println(stickCount);
    }
}
