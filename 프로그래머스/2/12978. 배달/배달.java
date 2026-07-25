import java.util.*;
class Solution {
    
    static class Node implements Comparable<Node>{
        int next, cost;
        Node(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    static int N, K;
    static int[] dist;    
    static ArrayList<Node>[] adj;
    public int solution(int n, int[][] roads, int k) {
        int answer = 0;
        N = n;
        K = k;
        adj = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            int cost = road[2];
            adj[a].add(new Node(b, cost));
            adj[b].add(new Node(a, cost));
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra();
        
        for(int i = 1; i <= N; i++) if(dist[i] <= K) answer++;
        
        return answer;
    }
    
    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now_place = node.next;
            int now_cost = node.cost;
            
            for(Node next : adj[now_place]){
                int next_place = next.next;
                int next_cost = next.cost;
                if(dist[next_place] > now_cost + next_cost){
                    dist[next_place] = now_cost + next_cost;
                    pq.add(new Node(next_place, dist[next_place]));
                }
            }
        }
    }
}