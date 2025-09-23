import java.io.*;
import java.util.*;

public class Main {

    static int N, cnt;
    static int max_result = Integer.MIN_VALUE;
    static int min_result = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ord = new int[4];
        st = new StringTokenizer(br.readLine());

        int temp;
        cnt = 0;
        for (int i = 0; i < 4; i++) {
            temp = Integer.parseInt(st.nextToken());
            cnt += temp;
            ord[i] = temp;
        }

        dfs(arr[0], 1, ord);
        System.out.println(max_result);
        System.out.println(min_result);
    }

    public static void dfs(int sum, int idx, int[] ord){
        if(idx == N){
            max_result = Math.max(max_result, sum);
            min_result = Math.min(min_result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(ord[i] > 0){
                ord[i] -= 1;
                int temp = cal(sum, arr[idx], i);
                dfs(temp, idx + 1, ord);
                ord[i] += 1;
            }
        }
    }

    public static int cal(int sum, int num, int flag){
        if(flag == 0){
            return sum + num;
        }
        else if(flag == 1){
            return sum - num;
        }
        else if(flag == 2){
            return sum * num;
        }
        else {
            if (sum < 0) return -(Math.abs(sum) / num);
            else return sum / num;
        }
    }



}

