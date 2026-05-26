import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : works) {
            pq.add(i);
        }

        while (!pq.isEmpty() && n > 0){
            int now = pq.poll();
            if(now == 0) continue;
            n--;
            pq.add(now - 1);
        }
        long answer = 0;
        while (!pq.isEmpty()){
            int now = pq.poll();
            answer += (now * now);
        }
        return answer;
    }
}