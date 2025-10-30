import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> pq = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            int left = 100 - progresses[i];
            int day = left / speeds[i];
            if(left % speeds[i] != 0) day++;
            pq.add(day);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            int cnt = 1;
            int now = pq.poll();
            while(!pq.isEmpty()){
                if(now >= pq.peek()){
                    cnt++;
                    pq.poll();
                }
                else break;   
            }
            result.add(cnt);
        }
        
        return result;
    }
}