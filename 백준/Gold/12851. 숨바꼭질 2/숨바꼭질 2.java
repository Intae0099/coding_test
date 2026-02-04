import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int now, time;
        Node(int now, int time){
            this.now = now;
            this.time = time;
        }
    }

    static int N, K, result_cnt;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[N] = 0;

        result_cnt = 0;
        bfs(N);

    }

    public static void bfs(int start){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()){
            Node node = q.poll();

            int now = node.now;
            int time = node.time;

            if(arr[K] < time) continue;

            if(now == K){
                if(time == arr[K]){
                    result_cnt ++;
                }
                else{
                    result_cnt = 1;
                    arr[K] = time;
                }
                continue;
            }


            if(now + 1 < 100001){
                if(arr[now + 1] >= time + 1){
                    arr[now + 1] = time + 1;
                    q.add(new Node(now + 1, time + 1));
                }
            }

            if(now - 1 >= 0){
                if(arr[now - 1] >= time + 1){
                    arr[now - 1] = time + 1;
                    q.add(new Node(now - 1, time + 1));
                }
            }

            if(now * 2 < 100001){
                if(arr[now * 2] >= time + 1){
                    arr[now * 2] = time + 1;
                    q.add(new Node(now * 2, time + 1));
                }
            }
        }

        System.out.println(arr[K]);
        System.out.println(result_cnt);
    }
}
