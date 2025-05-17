import java.util.*;
import java.io.*;

public class Main{

    static class Node implements Comparable<Node>{
        int next, weight;
        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node){
            return this.weight - node.weight;
        }
    }

    static int N, M, X, result;
    static ArrayList<Node>[] adj;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        result = 0;
        for(int i = 0; i < N+1; i++) adj[i] = new ArrayList<>();

        int a, b, c;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
        }

        int[] fromX = dijkstra(X);
        int result = 0;
        for(int i = 1; i <= N; i++){
            if(i == X) continue;
            int[] toX = dijkstra(i);
            int roundTrip = toX[X] + fromX[i];
            result = Math.max(result, roundTrip);
        }

        System.out.println(result);
    }
    static int[] dijkstra(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.weight > dist[now.next]) continue;

            for(Node next : adj[now.next]){
                if(dist[next.next] > dist[now.next] + next.weight){
                    dist[next.next] = dist[now.next] + next.weight;
                    q.add(new Node(next.next, dist[next.next]));
                }
            }
        }
        return dist;
    }
}