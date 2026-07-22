import java.util.*;

class Solution {
    static int N;
    static ArrayList<Integer>[] adj;
    public int solution(int n, int[][] wires) {
        N = n;
        adj = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int[] wire : wires){
            int cnt1 = check(wire[0], wire[1]);
            int cnt2 = check(wire[1], wire[0]);
            int sub = (int) Math.abs(cnt1 - cnt2);
            answer = Math.min(answer, sub);
        }
        
        return answer;
    }
    
    public static int check(int start, int end){
        int cnt = 1;
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == end) continue;
            for(int next : adj[now]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
        
    }
}