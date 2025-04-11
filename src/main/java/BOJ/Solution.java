package BOJ;

class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0, target);
        return answer;
    }

    public static void dfs(int[] numbers, int index, int sum, int target) {
        if (index == numbers.length) {
            if (sum == target) {  //모든 수를 다 사용했고, 합이 타겟과 같으면 종료
                answer += 1;
                return;
            } else {
                return;
            }
        }
        dfs(numbers, index + 1, sum + numbers[index], target);
        dfs(numbers, index + 1, sum - numbers[index], target);
    }
}