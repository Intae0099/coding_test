import java.util.*;
import java.io.*;
public class Solution {
	
	static class Wall{
		int x, y, weight;
		Wall(int x, int y, int weight){
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	
	
	static int N, W, H, result;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	for (int t = 1; t <= T; t++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		W = Integer.parseInt(st.nextToken());
    		H = Integer.parseInt(st.nextToken());
    		map = new int[H][W];
    		for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//    		print(map);
    		result = Integer.MAX_VALUE;
    		for (int location = 0; location < W; location++) {
//    			System.out.println("시작 : " + location);
				map_break(location, 1, map);
			}
    		System.out.printf("#%d %d\n", t, result);
    	}
	}
	private static void map_break(int location, int count, int[][] temp_map) {
		if(count == N+1) {
			int cnt = count(temp_map);
			result = Math.min(result, cnt);
			return;
		}
		
		int[][] clone_map = clone(temp_map);
		
		// 맵 부수기
		int[][] broken_map = clone_break(clone_map, location);
		
		
		
		// 부순 후 이동하기
		for (int i = 0; i < W; i++) {
			
			map_break(i, count + 1, broken_map);
		}
		
		
	}
	private static int[][] clone_break(int[][] clone_map, int location) {
		int y = location;
		int x = 0;
		
		while(true) {
			if(x >= H) return clone_map;
			if(clone_map[x][y] > 0) break;
			
			x += dx[0];
		}
//		System.out.println(location + " 에서 부서진 x" +x);
		if(clone_map[x][y] == 1) {
			clone_map[x][y] = 0;
			return clone_map;
		}
		
		// 벽 다 부수기
		Queue<Wall> q = new ArrayDeque<>();
		q.add(new Wall(x, y, clone_map[x][y]));
		
		Wall wall;
		int nx, ny;
		while(!q.isEmpty()) {
			wall = q.poll();
			clone_map[wall.x][wall.y] = 0;
			for (int i = 1; i < wall.weight; i++) {
				for (int d = 0; d < 4; d++) {
					nx = wall.x + dx[d] * i;
					ny = wall.y + dy[d] * i;
					if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
					if(clone_map[nx][ny] > 1) q.add(new Wall(nx, ny, clone_map[nx][ny]));
					clone_map[nx][ny] = 0;
				}
			}
		}
//		System.out.println("location : " + location +" 에서 부순 맵");
//		print(clone_map);
		
		
		// 벽 내려오기
		int temp_h;
		for (int w = 0; w < W; w++) {
			for (int h = H-1; h > 0; h--) {
				if(clone_map[h][w] == 0) {
					temp_h = h - 1;
					while(temp_h >= 0) {
						if(clone_map[temp_h][w] > 0) {
							clone_map[h][w] = clone_map[temp_h][w];
							clone_map[temp_h][w] = 0;
							h -= 1;
						}
						temp_h -= 1;
					}
				}
			}
		}
		
		
//		System.out.println();
//		System.out.println("침몰한 맵");
//		print(clone_map);
		
		
		return clone_map;
	}
	private static int[][] clone(int[][] temp_map) {
		int[][] new_map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				new_map[i][j] = temp_map[i][j];
			}
		}
		return new_map;
	}
	private static int count(int[][] temp_map) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(temp_map[i][j] > 0) cnt += 1;
			}
		}
		return cnt;
	}

	private static void print(int[][] temp_map) {
		for (int i = 0; i < H; i++) {
			System.out.println(Arrays.toString(temp_map[i]));
		}
	}
     
}