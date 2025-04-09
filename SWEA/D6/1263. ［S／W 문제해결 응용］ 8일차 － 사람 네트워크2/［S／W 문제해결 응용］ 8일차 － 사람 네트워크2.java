import java.util.*;
import java.io.*;
public class Solution {
	
	static int N, result;
	static int[][] adj;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	for (int t = 1; t <= T; t++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		adj = new int[N][N];
    		int temp;
    		for (int i = 0; i < N; i++) {
    			Arrays.fill(adj[i], 1002);
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken());
					if(temp != 0) {
						adj[i][j] = temp;
					}
					 
				}
			}
    		
    		for (int k = 0; k < N; k++) {
    			for (int i = 0; i < N; i++) {
    				for (int j = 0; j < N; j++) {
    					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
    				}	
    			}
			}
    		
    		result = Integer.MAX_VALUE;
    		int sum;
    		for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < N; j++) {
					sum += adj[i][j];
				}
				result = Math.min(sum - adj[i][i], result);
			}
    		
    		sb.append("#" + t + " " + result + "\n");
    	}
    	System.out.println(sb);
    }

	
     
}
