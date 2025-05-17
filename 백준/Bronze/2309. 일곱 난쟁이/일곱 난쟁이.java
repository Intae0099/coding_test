import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        recur(arr, new boolean[9], 0, 0);

    }
    static void recur(int[] arr, boolean[] visited, int idx, int cnt){

        if(cnt == 7){
            int result = 0;
            for(int i = 0; i < 9; i++){
                if(visited[i]) result += arr[i];
            }
            if(result == 100){
                for(int i = 0; i < 9; i++){
                    if(visited[i]) System.out.println(arr[i]);
                }
                System.exit(0);
            }

        }

        if(idx > 8) return;
        
        visited[idx] = true;
        recur(arr, visited, idx + 1, cnt + 1);
        visited[idx] = false;
        recur(arr, visited, idx + 1, cnt);
    }
}