import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int next, weight;
        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    static int V, E, K;
    static ArrayList<Node>[] adj;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adj = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
        }


        sb = new StringBuilder();
//        for (int i = 1; i <= V ; i++) {
//            if(i == K) {
//                sb.append(0).append("\n");
//                continue;
//            }
//            bfs(i);
//        }

        bfs();

        System.out.println(sb);
    }

    public static void bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        int[] visited = new int[V+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[K] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            for (Node next : adj[now.next]) {
                if(now.weight + next.weight < visited[next.next]){
                    visited[next.next] = visited[now.next] + next.weight;
                    pq.add(new Node(next.next, now.weight + next.weight));
                }
            }

        }

        for (int i = 1; i <= V ; i++) {
            if(visited[i] > 1000001){
                sb.append("INF\n");
            }
            else{
                sb.append(visited[i]).append("\n");
            }
        }
    }
}
