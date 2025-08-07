import java.util.*;
import java.io.*;

public class Main {

    static int N, K, result;
    static int[] workout;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        workout = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            workout[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        dfs(0, new boolean[N], 500);
        System.out.println(result);

    }

    static void dfs(int cnt, boolean[] visited, int total){
        if(total < 500) return;
        
        if(cnt == N){
            if(total >= 500) result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(cnt + 1, visited, total - K + workout[i]);
                visited[i] = false;
            }
        }
    }


}