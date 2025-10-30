import java.util.*;
class Solution {
    static int answer = 0;
    static int len;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        recur(k, 0, dungeons, new boolean[len], 0);
        
        return answer;
    }
    
    public static void recur(int k, int idx, int[][] dungeons, boolean[] visited, int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i < len; i++){
            if(!visited[i] && k - dungeons[i][1] >= 0 && k >= dungeons[i][0]){
                visited[i] = true;
                recur(k - dungeons[i][1], idx + 1, dungeons, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}