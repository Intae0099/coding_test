import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int now : scoville){
            pq.add(now);
        }
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            int food1 = pq.poll();
            if(food1 >= K) break;
            if(pq.isEmpty()) {
                if(food1 < K) answer = 0;
                break;
            }
            
            int food2 = pq.poll();
            pq.add(food1 + (food2) * 2);
            answer++;
        }
        
        
        if(answer == 0) {
            if(!pq.isEmpty() && pq.peek() >= K) return 0;
            return -1;
        }
        return answer;
    }
}