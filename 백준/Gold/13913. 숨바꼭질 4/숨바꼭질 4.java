import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
            System.out.println(N);
        }
        else{
            bfs();
        }


    }

    public static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        int[] time = new int[100001];
        int[] prev = new int[100001];
        
        Arrays.fill(time, 100001);
        time[N] = 0;
        
        while (!q.isEmpty()){
            int now = q.poll();

            if(now == K) break;

            for (int next : new int[] {now + 1, now - 1, now * 2}) {
                if(next < 0 || next > 100000) continue;
                if(time[next] == 100001){
                    time[next] = time[now] + 1;
                    prev[next] = now;
                    q.add(next);

                }

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time[K]).append("\n");

        int now = K;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(K);
        while (true){
            now = prev[now];
            if(now == N) break;
            arr.add(now);

        }

        arr.add(N);

//        for (int i : arr.reversed()){
//            sb.append(i).append(" ");
//        }

        for (int i = arr.size() - 1; i >= 0; i--){
            sb.append(arr.get(i)).append(" ");
        }
        System.out.println(sb);


    }


}
