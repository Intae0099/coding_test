import java.util.*;
import java.io.*;
public class Solution {
    
    static class Node implements Comparable<Node> {
        int x, y, time, cnt;
        Node(int x, int y, int time, int cnt){
            this.x = x;
            this.y = y;
            this.time = time;
            this.cnt = cnt;
        }
		@Override
		public int compareTo(Solution.Node o) {
			// TODO Auto-generated method stub
			return o.time - this.time;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", time=" + time + ", cnt=" + cnt + "]";
		}
		
		
    }
    
    static int N, M, K, result;
    static int[][] map;
    // 죽은 상태면 true;
    static boolean[][] visited;
    static int mapsize = 400;
    static int[] dx = {1, -1, 0,0};
    static int[] dy = {0,0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            map = new int[mapsize][mapsize];
            visited = new boolean[mapsize][mapsize];
            
            for (int i = mapsize / 2 - N; i < mapsize / 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = mapsize / 2 - M; j < mapsize / 2; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
                
            result = bfs();
            
            System.out.printf("#%d %d\n", t, result);
//            print(map);
            
        }
        
    }
    private static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 0; i < mapsize; i++) {
			for (int j = 0; j < mapsize; j++) {
				if(map[i][j] > 0) {
					q.add(new Node(i, j, map[i][j], map[i][j] * 2));
					visited[i][j] = true;
				}
			}
		}
        int qsize, nx, ny;
        Node temp;
        for (int time = 0; time < K; time++) {
			qsize = q.size();
			for (int size = 0; size < qsize; size++) {
				temp = q.poll();
				// 비활성 상태
				if(temp.cnt > temp.time) {
					temp.cnt -= 1;
					q.add(temp);
				}
				// 활성 하고 퍼져 나갈 때
				else if (temp.cnt == temp.time){
					pq.add(temp);
					temp.cnt -= 1;
					if(temp.cnt == 0) continue;
					q.add(temp);
				}
				// 활성화 된 상태
				else if (temp.cnt > 1) {
					temp.cnt -= 1;
					if(temp.cnt == 0) continue;
					q.add(temp);
				}
				// 그 외는 죽은 상태 q에서 빼기

			}
			qsize = pq.size();
			for (int pqsize = 0; pqsize < qsize; pqsize++) {
				temp = pq.poll();
				// 활성만 됬으면
//				if(temp.cnt > 0) {
//					temp.cnt -= 1;
//					pq.add(temp);
//					continue;
//				}
				
				// 전이 후 죽을 때
				for (int d = 0; d < 4; d++) {
					nx = temp.x + dx[d];
					ny = temp.y + dy[d];
					if(nx < 0 || nx > mapsize || ny < 0 || ny > mapsize) continue;
					if(!visited[nx][ny]) {
						map[nx][ny] = temp.time;
						visited[nx][ny] = true;
						q.add(new Node(nx, ny, temp.time, temp.time * 2));
					}
				}
			}
		}
//        System.out.println(Arrays.toString(q.toArray()));
        return q.size();
        
        
    }
    private static void print(int[][] map2) {
        for (int i = 0; i < mapsize; i++) {
            System.out.println(Arrays.toString(map2[i]));
        }
        
    }
    
    private static int count(int[][] map2) {
        int cnt = 0;
        for (int i = 0; i < mapsize; i++) {
            for (int j = 0; j < mapsize; j++) {
                if(map2[i][j] > 0) cnt += 1;
            }
        }
        return cnt;
    }
    
    
}



/*
1. 퍼져나감
2. 비활성상태 활성
3. 
 */