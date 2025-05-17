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

    static int V, E;
    static ArrayList<Node>[] adj;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i = 0; i <= V; i++) adj[i] = new ArrayList<>();
        int a, b, c;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
//        for(int i = 1; i <= E; i++) Collections.sort(adj[i]);


        int result = bfs();

        System.out.println(result);

    }
    public static int bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        int total = 0;

        q.add(new Node(1, 0));

        Node node;
        while(!q.isEmpty()){
            node = q.poll();
            if(visited[node.next]) continue;
            visited[node.next] = true;
            total += node.weight;

            for(Node next : adj[node.next]){
                if(!visited[next.next]) q.add(next);
            }
        }

        return total;

    }
}