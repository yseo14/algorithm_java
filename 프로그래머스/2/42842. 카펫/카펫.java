// 갈색 개수 = (노란색세로 + 2) * (노란색 가로 + 2) - 노란색
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int h = 1; h * h <= yellow; h++) {
            int w = yellow / h;
            if((h + 2) * (w + 2) - yellow == brown) {
                answer[0] = w + 2;
                answer[1] = h + 2;
            }
        }
        return answer;
    }
}