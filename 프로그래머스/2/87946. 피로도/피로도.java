import java.util.*;
class Solution {
    static int N, K, result;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        K = k;
        result = 0;
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        dfs(0, arr, dungeons);
        return result;
    }
    
    public void dfs(int depth, int[] order, int[][] dungeons){
        if(depth == N){
            int now_k = K;
            int cnt = 0;
            for(int i = 0; i < N; i++){
                int idx = order[i];
                if(now_k < dungeons[idx][0]) continue;
                now_k -= dungeons[idx][1];
                cnt++;
            }
            
            result = Math.max(result, cnt);
        }
        
        for(int i = 0; i < N; i++){
            if(order[i] != -1) continue;
            order[i] = depth;
            dfs(depth + 1, order, dungeons);
            order[i] = -1;
        }
        
    }
}