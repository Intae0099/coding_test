import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static ArrayList<Integer>[] adj;
    static StringBuilder dfs_sb, bfs_sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        dfs_sb = new StringBuilder();
        bfs_sb = new StringBuilder();

        adj = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        int a, b;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        for(int i = 1; i <= N; i++) Collections.sort(adj[i]);

        dfs(V, new boolean[N+1]);
        bfs(V);

        System.out.println(dfs_sb);
        System.out.println(bfs_sb);
    }

    public static void dfs(int V, boolean[] visited){
        if(visited[V]) return;

        visited[V] = true;
        dfs_sb.append(V + " ");

        for(int node : adj[V]){
            if(!visited[node]) dfs(node, visited);
        }
    }

    public static void bfs(int V){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        visited[V] = true;
        q.add(V);
        bfs_sb.append(V + " ");

        int node;
        while(!q.isEmpty()){
            node = q.poll();
            for(int k : adj[node]){
                if(!visited[k]){
                    visited[k] = true;
                    bfs_sb.append(k + " ");
                    q.add(k);
                }
            }
        }


    }
}