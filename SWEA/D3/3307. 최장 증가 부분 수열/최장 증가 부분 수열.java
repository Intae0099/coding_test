import java.util.*;
import java.io.*;
public class Solution {
	
	static int N;
	static int[] arr, dp;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
    		N = Integer.parseInt(br.readLine());
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		arr = new int[N];
    		dp = new int[N];
    		Arrays.fill(dp, 1);
    		for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
    		
    		for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(arr[i] < arr[j]) {
						dp[j] = Math.max(dp[j], dp[i] + 1);
					}
				}
			}
			
    		Arrays.sort(dp);
    		System.out.printf("#%d %d\n",t, dp[N-1]);
    		
    	}
    }

	
     
}
