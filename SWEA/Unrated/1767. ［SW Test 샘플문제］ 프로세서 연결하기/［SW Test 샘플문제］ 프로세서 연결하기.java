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

    static int[][] map;
    static ArrayList<Node> nodes;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, maxConnected, minWireLength;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            nodes = new ArrayList<>();
            map = new int[N][N];
            maxConnected = 0;
            minWireLength = Integer.MAX_VALUE;
            StringTokenizer st;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        nodes.add(new Node(i, j));
                    }
                }
            }

            dfs(0, 0, 0);
            System.out.printf("#%d %d\n", t, minWireLength);
        }
    }

    private static void dfs(int idx, int connected, int wireLength) {
        if (idx == nodes.size()) {
            if (connected > maxConnected) {
                maxConnected = connected;
                minWireLength = wireLength;
            } else if (connected == maxConnected) {
                minWireLength = Math.min(minWireLength, wireLength);
            }
            return;
        }

        Node cur = nodes.get(idx);
        boolean canConnect = false;

        for (int d = 0; d < 4; d++) {
            List<Node> wires = new ArrayList<>();
            if (canPlaceWire(cur.x, cur.y, d, wires)) {
                placeWire(wires, 2); 
                dfs(idx + 1, connected + 1, wireLength + wires.size());
                placeWire(wires, 0);
                canConnect = true;
            }
        }

        dfs(idx + 1, connected, wireLength);
    }

    private static boolean canPlaceWire(int x, int y, int d, List<Node> wires) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) return true;
            if (map[nx][ny] != 0) return false;
            wires.add(new Node(nx, ny));
        }
    }

    private static void placeWire(List<Node> wires, int val) {
        for (Node n : wires) {
            map[n.x][n.y] = val;
        }
    }
}
