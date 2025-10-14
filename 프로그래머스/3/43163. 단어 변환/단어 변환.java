// 최소면 BFS? 아니면 DFS로 완탐
class Solution {
    public boolean[] isUsed;
    public int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        isUsed = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String curr, String target, String[] words, int cnt) {
        if(curr.equals(target)) {
            answer = cnt;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(isUsed[i]) continue;
            
            if(canConvert(curr, words[i])) {
                isUsed[i] =  true;
                dfs(words[i], target, words, cnt+1);
                isUsed[i] =  false;
            }
        }
    }
    
    public boolean canConvert(String from, String to) {
         int cnt = 0;
         for(int i = 0; i < from.length(); i++) {
             if(from.charAt(i) != to.charAt(i)) {
                 cnt++;
             }
         }
         return cnt == 1; 
    } 
}