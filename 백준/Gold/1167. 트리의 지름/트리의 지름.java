import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int e, cost;
        Node(int e, int cost){
            this.e = e;
            this.cost = cost;
        }
    }
    static int V;
    static int result = 0;
    static int farNode = 0;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        adj = new ArrayList[V+1];
        visited = new boolean[V+1];


        for(int i = 1; i < V+1; i++){
            adj[i] = new ArrayList<>();
        }

        int start, next, len;
        for(int i = 1; i < V+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                next = Integer.parseInt(st.nextToken());
                if(next == -1) break;
                len = Integer.parseInt(st.nextToken());
                adj[start].add(new Node(next, len));
            }
        }

        dfs(1, 0);
        result = 0;
        visited = new boolean[V+1];
        dfs(farNode, 0);
        System.out.println(result);

    }

    static void dfs(int now, int dist){
        visited[now] = true;

        if(dist > result){
            result = dist;
            farNode = now;
        }

        for(Node node : adj[now]){
            if(!visited[node.e]){
                dfs(node.e, dist + node.cost);
            }
        }
    }

}
