package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sol1475 {

    static int[] nums;
    static String roomNo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        roomNo = br.readLine();
        nums = new int[10];
        for (char c : roomNo.toCharArray()) {
            int idx = c - '0';
            if (idx == 9) {
                idx = 6;
            }
            nums[idx]++;
        }
        nums[6] = nums[6] / 2 + nums[6] % 2;
        Arrays.sort(nums);
        System.out.println(nums[9]);
    }
}
