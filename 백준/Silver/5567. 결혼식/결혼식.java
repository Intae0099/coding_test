import java.util.*;
import java.io.*;
public class Main {

	static int N;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int a, b;
		
		adj = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		Queue<Integer> q = new ArrayDeque<>();
		int result = 0;
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
			
			if(a == 1) {
				q.add(b);
				visited[b] = true;
				result += 1;
			}
			else if (b == 1) {
				q.add(a);
				visited[a] = true;
				result += 1;
			}	
		}

		int x;
		
		while(!q.isEmpty()){
			x = q.poll();
			for (int j : adj[x]) {
				if(!visited[j]) {
					visited[j] = true;
					result += 1;
				}
			}
		}
		
		System.out.println(result);
		
	}

}
