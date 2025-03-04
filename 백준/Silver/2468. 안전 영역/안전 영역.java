import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, max_num, result;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws Exception{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		max_num = 0;
		int temp;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());
				if(max_num < temp) max_num = temp;
				map[i][j] = temp;
			}
		}
		
		result = 0;
		
		int temp_result;
		for (int num = 0; num <= max_num; num++) {
			visit = new boolean[N][N];
			temp_result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > num && !visit[i][j]) {
						visit[i][j] = true;
						temp_result += 1;
						bfs(i,j, num);
					}
				}
			}
			
			if(result < temp_result) {
				result = temp_result;
			}
		}
		
		System.out.println(result);
		
	}
	
	
	private static void bfs(int x, int y, int num) {
		Queue<Point> q = new ArrayDeque<>(); 
		q.add(new Point(x, y));
		
		Point p;
		int nx, ny;
		while(!q.isEmpty()) {
			p = q.poll();
			x = p.x;
			y = p.y;
			
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				if(visit[nx][ny]) continue;
				if(map[nx][ny] <= num) continue;
				
				visit[nx][ny] = true;
				q.add(new Point(nx, ny));
			}
		}

	}


	static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	static void visit_print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
	}
	
}
