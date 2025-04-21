import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] nums = new Integer[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        
        Arrays.sort(nums, (a, b) ->{
            String ab = a.toString() + b.toString();
            String ba = b.toString() + a.toString();
            
            return ba.compareTo(ab);
        });
            
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        
        String result = sb.toString();
        if (result.charAt(0) == '0') result = "0";
        
        return result;
    }
}