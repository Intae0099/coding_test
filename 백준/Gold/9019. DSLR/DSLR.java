import java.util.*;
import java.io.*;

public class Main {

    static int[] prev;
    static int[] ord_list;
    static StringBuilder sb;
    static boolean[] visited;
    static char[] ord_idx = {'D', 'S', 'L', 'R'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        visited = new boolean[10000];
        prev = new int[10000];
        ord_list = new int[10000];
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(prev, -1);
            Arrays.fill(ord_list, -1);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A, B);
        }
        System.out.println(sb);

    }

    public static void bfs(int start, int end){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        Arrays.fill(visited, false);
        visited[start] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            if(now == end) break;

            for (int ord = 0; ord < 4; ord++) {
                int next = cal(now, ord);
                if(visited[next]) continue;
                q.add(next);
                prev[next] = now;
                ord_list[next] = ord;
                visited[next] = true;
            }
        }

        StringBuilder result = new StringBuilder();

        int check = end;
        while(true){
            result.append(ord_idx[ord_list[check]]);
            check = prev[check];
            if(check == start) break;
        }

        sb.append(result.reverse()).append("\n");


    }

    public static int cal(int now, int ord){
        int next = now;
        switch (ord){
            case 0 :
                next = (now * 2) % 10000;
                break;
            case 1 :
                next = now - 1;
                if(next < 0) next = 9999;
                break;
            case 2 :
                int l1 = now / 1000;
                next = (now * 10) % 10000 + l1;
                break;
            case 3 :
                int r1 = now % 10;
                next = (now / 10) + (r1 * 1000);
                break;
        }
        return next;
    }



}
