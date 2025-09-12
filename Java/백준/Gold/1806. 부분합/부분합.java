import java.util.*;
import java.io.*;

public class Main {

    static int N, S;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp_sum = new int[N];

        dp_sum[0] = dp[0];
        for (int i = 1; i < N; i++) {
            dp_sum[i] = dp_sum[i-1] + dp[i];
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (true){
            if(sum >= S){
                result = Math.min(result, right - left);
                sum -= dp[left];
                left++;
            }
            else if(right == N){
                break;
            }
            else {
                sum += dp[right];
                right++;
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
