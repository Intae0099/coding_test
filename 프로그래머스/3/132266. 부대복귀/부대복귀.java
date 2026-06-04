import java.util.*;
class Solution {
    static int result_len;
    static int[] result;
    static ArrayList<Integer>[] adj;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] road : roads){
            int a = road[0];
            int b = road[1];

            adj[a].add(b);
            adj[b].add(a);
        }
        result_len = sources.length;
        result = new int[result_len];

        for (int i = 0; i < result_len; i++) {
            if(sources[i] == destination) continue;
            int dist = dijkstra(sources[i], n, roads, sources, destination);
            result[i] = dist;
        }
        
        return result;
    }
    
    public static int dijkstra(int start, int n, int[][] roads, int[] sources, int destination){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {start, 0});
        boolean[] visited = new boolean[n+1];
        visited[start] = true;

        while (!q.isEmpty()){
            int[] node = q.poll();
            int now = node[0];
            int dist = node[1];

            if(now == destination){
                return dist;
            }

            for (int i : adj[now]) {
                if(visited[i]) continue;
                visited[i] = true;
                q.add(new int[] {i, dist + 1});
            }

        }

        return -1;
    }
}