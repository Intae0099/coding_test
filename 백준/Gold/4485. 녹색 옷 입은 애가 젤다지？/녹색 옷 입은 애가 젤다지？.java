import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int x, y, weight;
        Node(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    static int T = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            T++;
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }


            }
            dijkstr(N, board);
        }
    }

    public static void dijkstr(int N, int[][] board){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,0, board[0][0]));
        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = board[0][0];
        Node temp;
        while (!q.isEmpty()){
            temp = q.poll();
            if (temp.weight > visited[temp.x][temp.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                int newDist = temp.weight + board[nx][ny];
                if(newDist < visited[nx][ny]){
                    visited[nx][ny] = newDist;
                    q.add(new Node(nx, ny, newDist));
                }
            }
        }

        System.out.println("Problem " + T + ": " + visited[N-1][N-1]);


    }

}
