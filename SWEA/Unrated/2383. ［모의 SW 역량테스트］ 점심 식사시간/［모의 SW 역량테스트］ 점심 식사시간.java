import java.util.*;
import java.io.*;

public class Solution {
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, result;
	static int[][] map;
	static ArrayList<Node> nodes;      // 사람 목록
	static ArrayList<Node> door_nodes; // 계단 목록

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			map = new int[N][N];
			nodes = new ArrayList<>();
			door_nodes = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if (temp == 1) {
						nodes.add(new Node(i, j));  // 사람 좌표 저장
					} else if (temp > 1) {
						door_nodes.add(new Node(i, j));  // 계단 좌표 저장
					}
				}
			}

			// 사람 수만큼의 조합을 만들어서 시뮬레이션 진행
			recur(new boolean[nodes.size()], 0);

			System.out.printf("#%d %d\n", t, result);
		}
	}

	// 모든 사람들을 두 개의 계단 중 하나로 배치하는 조합 생성
	private static void recur(boolean[] visited, int idx) {
		if (idx == nodes.size()) {
			check(visited);
			return;
		}

		// 현재 idx 사람을 첫 번째 계단으로 배정
		visited[idx] = true;
		recur(visited, idx + 1);

		// 현재 idx 사람을 두 번째 계단으로 배정
		visited[idx] = false;
		recur(visited, idx + 1);
	}

	// 계단 별로 사람들을 분배 후 소요 시간 계산
	private static void check(boolean[] visited) {
		ArrayList<Integer> door1 = new ArrayList<>();
		ArrayList<Integer> door2 = new ArrayList<>();

		// 사람을 두 개의 계단으로 분배
		for (int i = 0; i < nodes.size(); i++) {
			int dist;
			if (visited[i]) { // 첫 번째 계단 선택
				dist = Math.abs(nodes.get(i).x - door_nodes.get(0).x) + Math.abs(nodes.get(i).y - door_nodes.get(0).y);
				door1.add(dist);
			} else { // 두 번째 계단 선택
				dist = Math.abs(nodes.get(i).x - door_nodes.get(1).x) + Math.abs(nodes.get(i).y - door_nodes.get(1).y);
				door2.add(dist);
			}
		}

		// 시간 계산
		int time1 = getTime(door1, map[door_nodes.get(0).x][door_nodes.get(0).y]);
		int time2 = getTime(door2, map[door_nodes.get(1).x][door_nodes.get(1).y]);

		// 결과 갱신
		result = Math.min(result, Math.max(time1, time2));
	}

	// 특정 계단을 이용하는 사람들의 총 소요 시간 계산
	private static int getTime(ArrayList<Integer> door, int stairTime) {
		if (door.isEmpty()) return 0; // 사람이 없으면 0초 소요

		Collections.sort(door); // 계단 도착 시간 오름차순 정렬
		Queue<Integer> stairQ = new LinkedList<>(); // 계단을 내려가는 사람들

		int currentTime = 0;
		int index = 0;

		while (index < door.size() || !stairQ.isEmpty()) {
			// 계단에서 내려간 사람 제거
			while (!stairQ.isEmpty() && stairQ.peek() == currentTime) {
				stairQ.poll();
			}

			// 최대 3명까지만 계단을 내려갈 수 있음
			while (index < door.size() && stairQ.size() < 3) {
				int arrivalTime = door.get(index);
				index++;

				// 만약 계단이 비어있다면 바로 내려감, 아니라면 기다려야 함
				int startTime = Math.max(arrivalTime, currentTime);
				stairQ.offer(startTime + stairTime);
			}

			// 시간 증가
			currentTime++;
		}

		return currentTime;
	}
}
