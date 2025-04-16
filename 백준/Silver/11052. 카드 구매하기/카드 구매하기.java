import java.util.*;
import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i + j <= N) {
					dp[i+j] = Math.max(dp[i + j] , dp[j] + arr[i]);
				}
					dp[j] = Math.max(dp[j], arr[j]);
				
			}
		}
		System.out.println(dp[N]);
	}
}
