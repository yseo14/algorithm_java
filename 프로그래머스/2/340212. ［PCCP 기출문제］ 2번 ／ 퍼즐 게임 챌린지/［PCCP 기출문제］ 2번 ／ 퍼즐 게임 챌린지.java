class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        // min, max 세팅
        int max = 300000;
        int min = 1;
     
        // 이분 탐색 
        while(min<max){
            int level = (min+max)/2;
            // 해결 가능하면 
            if(isResolve(diffs, times, limit, level)){
                max = level;
            // 해결 불가능하면
            }else{
                min = level+1;
            }
        }

        return max;
    }
    
    // 시간내 문제 풀이 할 수 있는지 판별 함수
    boolean isResolve(int[] diffs, int[] times, long limit, int level){
        long sum = 0;
        for(int i=0;i<times.length;i++){
            if(diffs[i]<=level){
                sum+=times[i]; // level 이하면, 현재 시간 더하기 
            }else{
                int minus = diffs[i]-level;
                // level 초과면, 수식 적용하기
                sum+=(times[i]+times[i-1])*minus +times[i];
            }
            if(limit<sum) return false;
        }
        return true;
    }
}