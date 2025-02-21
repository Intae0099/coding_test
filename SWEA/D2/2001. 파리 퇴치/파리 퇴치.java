import java.util.*;
import java.io.*;

public class Solution {
	
	static int N, M, result;
	static int[][] map;
	static int[][] pre_sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			pre_sum = new int[N+1][N+1];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					map[i-1][j-1] = Integer.parseInt(st.nextToken());
					pre_sum[i][j] = map[i-1][j-1] + pre_sum[i-1][j] + pre_sum[i][j-1] - pre_sum[i-1][j-1]; 
				}
			}
			
			result = 0;
			calc();
			System.out.printf("#%d %d\n", t, result);
			
		}

	}
	private static void calc() {
		int sum = 0;
		for (int i = M; i <= N; i++) {
			for (int j = M; j <= N; j++) {
				sum = pre_sum[i][j] - pre_sum[i-M][j] - pre_sum[i][j-M] + pre_sum[i-M][j-M];
				if(result < sum) {
					result = sum;
				}
			}
		}
		
	}

}
