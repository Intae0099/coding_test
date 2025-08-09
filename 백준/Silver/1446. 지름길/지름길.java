import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int from, to, dist;
        Node(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    static int N, D, result_dist;

    static int[] dp;
    static ArrayList<Node> shortcut;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortcut = new ArrayList<>();

        int start, end, cost;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            if(end - start <= cost ) continue;
            if(end > D) continue;

            shortcut.add(new Node(start, end, cost));
        }

        dp = new int[D+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i <= D ; i++) {
            if(i > 0) dp[i] = Math.min(dp[i], dp[i-1] + 1);

            for(Node node : shortcut){
                if(node.from == i){
                    dp[node.to] = Math.min(dp[node.to], dp[i] + node.dist);
                }
            }
        }

        System.out.println(dp[D]);

    }

}
