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
	
	static int N, result;
	static int[][] map;
	static ArrayList<Node> nodes;
	static ArrayList<Node> door_nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int temp;
        for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			map = new int[N][N];
			nodes = new ArrayList<>();
			door_nodes = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if(temp == 1) {
						nodes.add(new Node(i, j));
					}
					else if (temp > 1) {
						door_nodes.add(new Node(i, j));
					}
				}
			}
			
			recur(new boolean[nodes.size()], 0);
			
			System.out.printf("#%d %d\n", t, result);
		}
        
        
    }
	private static void recur(boolean[] visited, int idx) {
		if(idx == nodes.size()) {
			check(visited);
			return;
		}
		
		visited[idx] = true;
		recur(visited, idx + 1);
		
		visited[idx] = false;
		recur(visited, idx + 1);
		
	}
	private static void check(boolean[] visited) {
		int dist;
		ArrayList<Integer> door1 = new ArrayList<>();
		ArrayList<Integer> door2 = new ArrayList<>();
		for (int i = 0; i < nodes.size(); i++) {
			// true 면 1번
			if(visited[i]) {
				dist = Math.abs(nodes.get(i).x - door_nodes.get(0).x) + Math.abs(nodes.get(i).y - door_nodes.get(0).y);
				door1.add(dist);
			}
			// false 면 2번
			else {
				dist = Math.abs(nodes.get(i).x - door_nodes.get(1).x) + Math.abs(nodes.get(i).y - door_nodes.get(1).y);
				door2.add(dist);
			}
		}
		
		int time1 = getTime(door1, map[door_nodes.get(0).x][door_nodes.get(0).y]);
		int time2 = getTime(door2, map[door_nodes.get(1).x][door_nodes.get(1).y]);
		
		result = Math.min(result, Math.max(time1, time2));
		
		
	}

	private static int getTime(ArrayList<Integer> door, int stair_time) {
		if(door.isEmpty()) return 0;
		
		Collections.sort(door);
		
		Queue<Integer> stairQ = new LinkedList<>();
		
		int currentTime = 0;
		int idx = 0;
		
		while(idx < door.size() || !stairQ.isEmpty()) {
			while(!stairQ.isEmpty() && stairQ.peek() == currentTime) {
				stairQ.poll();
			}
			
			while(idx < door.size() && stairQ.size() < 3) {
				int arrivalTime = door.get(idx);
				idx += 1;
				
				int startTime = Math.max(arrivalTime, currentTime);
				stairQ.add(startTime + stair_time);
			}
			
			currentTime++;
		}
		
		return currentTime;
		
	}
     
}

