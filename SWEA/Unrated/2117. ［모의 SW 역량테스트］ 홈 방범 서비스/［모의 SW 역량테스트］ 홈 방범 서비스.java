import java.util.*;
import java.io.*;
public class Solution {
	
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	static int N, M, result;
	static int[][] map;
	static ArrayList<Node> nodes;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			nodes = new ArrayList<>();
			int temp;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken()); 
					map[i][j] = temp;
					if(temp == 1) {
						nodes.add(new Node(i, j));
					}
				}
			}
			
			result = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp = check(i, j);
					if(result < temp) {
						result = temp;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
			
		}
        
	}
	private static int check(int i, int j) {
		int cost, cnt, dist;
		int result = 0;
		for (int k = 1; k < N * N; k++) {
			cnt = 0;
			cost = k * k + (k-1) * (k-1);
			for (Node node : nodes) {
				dist = Math.abs(node.x - i) + Math.abs(node.y - j);
				if(dist < k) {
					cnt += 1;
				}
			}
			if(cnt * M - cost >= 0) {
				result = Math.max(result, cnt);
			}
		}
		
		
		return result;
	}
	
     
}
