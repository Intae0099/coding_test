import java.util.*;
class Solution {
    static ArrayList<Integer>[] adj;
    static int result;
    public int solution(int n, int[][] wires) {
        adj = new ArrayList[n + 1];
        result = 101;
        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
                             
        for(int[] wire : wires){
            boolean[] visited = new boolean[n + 1];
            visited[wire[0]] = true;
            visited[wire[1]] = true;
            int cnt1 = bfs(wire[0], visited);
            int cnt2 = bfs(wire[1], visited);
            
            result = Math.min(result, (int) Math.abs(cnt1 - cnt2));
        }
        
        return result;
    }
                             
    public static int bfs(int now, boolean[] visited){
        int cnt = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(now);
        
        int temp;
        while(!q.isEmpty()){
            temp = q.poll();
            for(int next : adj[temp]){
                if(!visited[next]){
                    visited[next] = true;
                    cnt++;
                    q.add(next);
                }
            }
        }
        
        return cnt;
    }
                             
}