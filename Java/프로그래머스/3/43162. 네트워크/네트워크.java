import java.util.*;
class Solution {
    static ArrayList<Integer>[] adj;
    public int solution(int n, int[][] computers) {
        adj = new ArrayList[n];
        for(int i = 0; i <n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    adj[i].add(j);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]) {
                answer++;
                bfs(visited, i);
                
            }
        }
        
        
        return answer;
    }
    
    public static void bfs(boolean[] visited, int now){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(now);
        
        int temp;
        while(!q.isEmpty()){
            temp = q.poll();
            for(int next : adj[temp]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}