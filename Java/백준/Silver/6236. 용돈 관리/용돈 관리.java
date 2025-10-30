import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] days;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        days = new int[N];
        int right = 0;
        int left = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            days[i] = num;
            right += num;
            left = Math.max(left, num);
        }


        int result = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            int before = 0;
            for (int i = 0; i < N; i++) {
                before += days[i];
                if(before > mid){
                    cnt++;
                    before = days[i];
                }
            }
            if(before > 0) cnt++;

            if(cnt <= M){
                right = mid - 1;
                result = mid;
            }
            else{
                left = mid + 1;
            }

        }

        System.out.println(result);


    }

}
