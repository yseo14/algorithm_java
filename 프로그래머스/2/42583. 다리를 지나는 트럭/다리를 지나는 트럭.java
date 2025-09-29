import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) throws Exception{
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridgeLength; i++) {
            q.add(0);
        }
        
        int bridgeWeight = 0;
        int time = 0;
        int nextTruck = 0;
        
        while(nextTruck < truckWeights.length) {
            time++;
            int passed = q.poll();
            bridgeWeight -= passed;
            
            int nextTruckWeight = truckWeights[nextTruck];
            if(bridgeWeight + nextTruckWeight <= weight) {
                q.add(nextTruckWeight);
                bridgeWeight += nextTruckWeight;
                nextTruck++;
            } else {
                q.add(0);
            }
        }
        return bridgeLength + time;
        
    }
}