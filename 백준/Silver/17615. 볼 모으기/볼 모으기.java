import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int result = Integer.MAX_VALUE;
    static char[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        result = Math.min(result, check_move('R'));
        result = Math.min(result, check_move('B'));

        System.out.println(result);

    }

    public static int check_move(char color){
        int idx = N-1;
        while (idx >= 0 && arr[idx] == color){
            idx--;
        }

        int cnt = 0;
        for (int i = 0; i < idx; i++) {
            if(arr[i] == color){
                cnt++;
            }
        }

        return cnt;

    }


}