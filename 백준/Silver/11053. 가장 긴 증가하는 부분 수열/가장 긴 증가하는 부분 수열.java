import java.util.*;
import java.io.*;

public class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i = 0; i < N; i++){
            for(int j = i+1; j< N; j++){
                if(arr[i] < arr[j]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int result = 0;
        for(int i : dp){
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}