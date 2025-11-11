import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int bit;
        boolean[] path; // 서, 북, 동, 남 순서로 벽 존재 여부
        Node(int bit){
            this.bit = bit;
            path = new boolean[4];
            check_path(bit, path);
        }
        public static void check_path(int bit, boolean[] path){
            // i: 0=서(1), 1=북(2), 2=동(4), 3=남(8)
            for (int i = 0; i < 4; i++) {
                int mask = 1 << i;
                if ((bit & mask) == mask) path[i] = true; // 벽이 있으면 true
            }
        }
    }

    static int N, M;                // N=행, M=열
    static int room_cnt;            // 방 개수
    static int room_area;           // 벽 안 부쉈을 때 최대 넓이
    static int max_room_area;       // 벽 하나 부순 뒤 최대 넓이
    static Node[][] map;

    // 서, 북, 동, 남 (BOJ 2234 비트 정의와 일치)
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int[][] roomId;          // 각 칸의 방 번호
    static ArrayList<Integer> roomSize = new ArrayList<>(); // index=방번호, value=넓이

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new Node[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int bit = Integer.parseInt(st.nextToken());
                map[i][j] = new Node(bit);
            }
        }

        room_cnt = 0;
        room_area = 0;
        max_room_area = 0;

        roomId = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(roomId[i], 0);
        roomSize.add(0); // 방 번호를 1부터 시작하기 위해 더미 값

        // 1) 방 라벨링: 벽이 없는 방향만 타고 같은 방을 BFS로 묶기
        int id = 0;
        boolean[][] visited = new boolean[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!visited[x][y]) {
                    id++;
                    int area = bfsLabel(x, y, id, visited);
                    roomSize.add(area);
                    room_area = Math.max(room_area, area);
                }
            }
        }
        room_cnt = id;

        // 2) 벽 하나를 부쉈을 때 최대 넓이: “벽이 있는 변”만 보며 서로 다른 방이면 합치기
        int best = room_area;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                int curId = roomId[x][y];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    // 벽이 있을 때만 고려 (벽 제거 시 합쳐짐)
                    if (map[x][y].path[d] && check(nx, ny)) {
                        int nxtId = roomId[nx][ny];
                        if (nxtId != curId) {
                            best = Math.max(best, roomSize.get(curId) + roomSize.get(nxtId));
                        }
                    }
                }
            }
        }
        max_room_area = best;

        System.out.println(room_cnt);
        System.out.println(room_area);
        System.out.println(max_room_area);
    }

    // 벽이 없는 방향으로만 퍼지는 BFS, 방문 칸에 동일한 roomId 부여, 넓이 반환
    public static int bfsLabel(int sx, int sy, int id, boolean[][] visited) {
        Queue<Point> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        roomId[sx][sy] = id;
        q.add(new Point(sx, sy));

        int area = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            area++;
            int x = p.x, y = p.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 벽이 없고, 범위 안이고, 미방문이면 같은 방으로 확장
                if (!map[x][y].path[d] && check(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    roomId[nx][ny] = id;
                    q.add(new Point(nx, ny));
                }
            }
        }
        return area;
    }

    public static boolean check(int nx, int ny){
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
