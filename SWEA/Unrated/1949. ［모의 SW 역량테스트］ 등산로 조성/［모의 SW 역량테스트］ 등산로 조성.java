import java.util.*;
import java.io.*;

public class Solution {
	
	static class Path{
		int x, y, dist, cut;
		
		Path(int x, int y, int dist, int cut){
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.cut = cut;
		}
	}
	
	static int N, K, result;
	static int[][] map;
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			// 0이 아직 안판거 1~K까지가 그 깊이 만큼 판거
			// 0 이 true면 그 자리 방문 1~K까지 true면 그 자리는 팠고 다른 자르 못파는거 감지
			
			
			int temp = 0;
			int max_height = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if(max_height < temp) max_height = temp;
				}
			}
			
			result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == max_height) {
						boolean[][][] visited = new boolean[N][N][2];
						visited[i][j][1] = true;
						DFS(i, j, visited, 1, 1);
						visited[i][j][1] = false;
					}
				}
			}
		
			System.out.printf("#%d %d\n", t, result);
		}
		
	}
	private static void DFS(int x, int y, boolean[][][] visited, int dist, int cut) {
		
		if(dist > result) result = dist;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			
			
			// 자르지 않고 탐색
			if(map[x][y] > map[nx][ny]) {

				if(visited[nx][ny][cut]) continue;
				visited[nx][ny][cut] = true;
				DFS(nx, ny, visited, dist + 1, cut);
				visited[nx][ny][cut] = false;
			}
			
			// 자를 경우
			if(cut == 1 && !visited[nx][ny][1]) {

				
				// 자른다
				for (int j = 1; j <= K; j++) {
				
					// 자른 높이가 현재 산보다 낮을 경우
					if(map[nx][ny] - j < map[x][y] && map[nx][ny] - j >= 0) {

						visited[nx][ny][0] = true;
						map[nx][ny] -= j;
						DFS(nx, ny, visited, dist + 1, 0);
						map[nx][ny] += j;
						visited[nx][ny][0] = false;
						break;
					}
						
				}
			}

			
		
			
		}
	}


}

