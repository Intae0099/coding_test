import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 0 : 무게, 1 : 가치
		int[][] knapsack = new int[N+1][2];
		int a, b;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			knapsack[i][0] = a;
			knapsack[i][1] = b;
		}
		
		int[][] dp = new int[N + 1][K+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < K+1; j++) {
				if(knapsack[i][0] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - knapsack[i][0]] + knapsack[i][1]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}

