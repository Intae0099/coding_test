import java.util.*;
import java.io.*;

public class Main {
    static int R, C, result;
    static char[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) board[i][j] = temp.charAt(j);
        }

        boolean[] alpha_visited = new boolean[26];
        alpha_visited[board[0][0] - 'A'] = true;

        dfs(0, 0, alpha_visited, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, boolean[] alpha_visited, int cnt) {
        if (result == 26) return;
        result = Math.max(result, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            int idx = board[nx][ny] - 'A';
            if (alpha_visited[idx]) continue;

            alpha_visited[idx] = true;
            dfs(nx, ny, alpha_visited, cnt + 1);
            alpha_visited[idx] = false;
        }
    }
}
