import java.io.*;
import java.util.*;
 
public class Main {
     
    static ArrayList<Integer>[] arr;
    static int[] big_cnt;
    static int[] small_cnt;
    static int result, N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            arr = new ArrayList[N+1];
            big_cnt = new int[N+1];
            small_cnt = new int[N+1];
            for (int i = 0; i < N+1; i++) {
                arr[i] = new ArrayList<>();
            }
            int a, b;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                arr[a].add(b);
            }
             
            result = 0;
            for (int i = 1; i < N+1; i++) {
                BFS(i, new boolean[N+1], i);
            }
             
            for (int i = 1; i < N+1; i++) {
                if(big_cnt[i] + small_cnt[i] == N-1) result += 1;
            }
             
            System.out.printf("%d\n", result);
        
         
    }
    private static void BFS(int num, boolean[] visited, int start_num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        int x, cnt = 0;
        while(!q.isEmpty()) {
            x = q.poll();
            for (int k : arr[x]) {
                if(!visited[k]) {
                    visited[k] = true;
                    q.add(k);
                    big_cnt[k] += 1;
                    small_cnt[start_num] += 1;
                }
            }
        }
         
    }
 
}