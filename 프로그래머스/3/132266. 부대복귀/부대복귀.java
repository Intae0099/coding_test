import java.util.*;
class Solution {
    static class Node{
        int next, dist;
        Node(int next, int dist){
            this.next = next;
            this.dist = dist;
        }
    }

    static ArrayList<Integer>[] adj;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        adj = new ArrayList[n+1];
        for (int i = 0; i <= n ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        int[] result = new int[sources.length];
        Arrays.fill(result, -1);
        boolean[] visited = new boolean[n+1];
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(destination, 0));

        while (!q.isEmpty()){
            Node node = q.poll();
            int now = node.next;
            int dist = node.dist;

            for (int i : adj[now]) {
                if (visited[i]) continue;
                visited[i] = true;
                cost[i] = dist + 1;
                q.add(new Node(i, dist + 1));
            }
        }

        for (int i = 0; i < sources.length; i++) {
            if(sources[i] == destination) {
                result[i] = 0;
                continue;
            }
            int now_cost = cost[sources[i]];
            if(now_cost == Integer.MAX_VALUE) result[i] = -1;
            else result[i] = now_cost;

        }        
        return result;
    }
}