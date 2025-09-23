import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        indegree = new int[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            indegree[b]++;
        }

        bfs();
        System.out.println(sb.toString().trim());
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int temp;
        while(!q.isEmpty()){
            temp = q.poll();
            sb.append(temp).append(" ");
            for(int num : adj[temp]){
                indegree[num]--;
                if(indegree[num] == 0){
                    q.add(num);
                }
            }
        }

    }





}

