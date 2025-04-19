class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 최악의 경우: 한쪽 끝까지 쭉 이동

        for (int i = 0; i < len; i++) {
            // 세로 조작 (알파벳 변경)
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 가로 조작 (커서 이동 최소화 계산)
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // i에서 왼쪽으로 갔다가 다시 우회해서 오는 경우 계산
            move = Math.min(move, i + i + len - next);
            // 또는 오른쪽 끝까지 갔다가 왼쪽으로 오는 경우
            move = Math.min(move, (len - next) * 2 + i);
        }

        answer += move;
        return answer;
    }
}