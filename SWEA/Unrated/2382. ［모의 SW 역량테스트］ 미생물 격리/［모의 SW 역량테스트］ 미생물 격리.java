import java.util.*;
import java.io.*;
public class Solution {
	
	static class Virus{
		int x, y, amount, dire;
		Virus(int x, int y, int amount, int dire){
			this.x = x;
			this.y = y;
			this.amount = amount;
			this.dire = dire;
		}
		@Override
		public String toString() {
			return "Virus [x=" + x + ", y=" + y + ", amount=" + amount + ", dire=" + dire + "]";
		}
		
	}
	
	static int N, M, K;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	static ArrayList<Virus> viruses;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			viruses = new ArrayList<>();
			
			int x, y, amount, dire;
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				amount = Integer.parseInt(st.nextToken());
				dire = Integer.parseInt(st.nextToken());				
				viruses.add(new Virus(x, y, amount, dire));
			}
//			print();
			// 시간마다 이동
			for (int time = 1; time <= M; time++) {
				// x, y, dire
//				System.out.println(time);
				BFS(new int[N][N][5]);
//				print();
			}
			
			int result = 0;
			// 바이러스 총 합
			for (Virus v : viruses) {
				result += v.amount;
			}
			System.out.printf("#%d %d\n", t, result);
		}
		
	}
	private static void print() {
		for (Virus v : viruses) {
			System.out.println(v.toString());
		}
		System.out.println();
	}
	
	
	private static void BFS(int[][][] map) {
		int nx, ny, dire, amount;
		
		
		for (int i = 0; i < viruses.size(); i++) {
			dire = viruses.get(i).dire;
			amount = viruses.get(i).amount;
			nx = viruses.get(i).x + dx[dire];
			ny = viruses.get(i).y + dy[dire];
			
			// 끝 부분에 닿앗을 때
			if(nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
				// 방향 전환
				switch(dire) {
					case 1:
						dire = 2;
						break;
					case 2:
						dire = 1;
						break;
					case 3:
						dire = 4;
						break;
					case 4:
						dire = 3;
						break;
				}
				// 총합의 나누기 2
				// 근데 합쳐지고 나누는거 vs 합치고 나누는거 이게 차이가 있겟네
				// 끝에서 합쳐지는 경우는 없지 않나?
				map[nx][ny][dire] = amount / 2;
				
			}
			// 그렇지않은경우 총합 그대로
			else {
				map[nx][ny][dire] = amount;
			}
			
		}
		int sum, max_d;
		viruses = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum = 0;
				max_d = 0;
				dire = 0;
				for (int d = 1; d < 5; d++) {
					// 해당 위치에 미생물 군집이 있을 때 
					if(map[i][j][d] > 0) {
						sum += map[i][j][d];
						dire = d;
						// 가장 큰 군집의 방향 설정
						if(max_d < map[i][j][d]) max_d = map[i][j][d];
					}
				}
				// 군집이 잇을 때
				if(sum > max_d) {
					for (int d = 1; d < 5; d++) {
						// 가장 큰 방향으로 설정
						if(max_d > 0 && max_d == map[i][j][d]) {
							dire = d;
							// array 재배치
							viruses.add(new Virus(i,j,sum,dire));
							break;
						}
						
						
					}
				}
				else if (sum > 0) {
					viruses.add(new Virus(i,j,sum,dire));
				}
			}
		}
		
	}

}
