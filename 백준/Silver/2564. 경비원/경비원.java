import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K, len;
    static int[] place;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        len = N * 2 + M * 2;

        place = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int dire = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            int total_dist = cal(dire, dist);

            place[i] = total_dist;
        }

        int result = 0;
        st = new StringTokenizer(br.readLine());
        int now_dire = Integer.parseInt(st.nextToken());
        int now_dist = Integer.parseInt(st.nextToken());
        int now_place = cal(now_dire, now_dist);

        for (int i : place) {
            int first = Math.abs(now_place - i);
            int second = len - first;
            result += Math.min(first, second);
        }
        
        System.out.println(result);
    }

    public static int cal(int dire, int dist){
        int total_dist = 0;
        switch (dire){
            case 1:
                total_dist = dist;
                break;
            case 2:
                total_dist = N + M + (N - dist);
                break;
            case 3:
                total_dist = N * 2 + M + (M - dist);
                break;
            case 4:
                total_dist = N + dist;
                break;

        }

        return total_dist;
    }
}


