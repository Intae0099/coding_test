import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //permutation(new boolean[9], 0, new int[7]);
        Arrays.sort(arr);
        combination(0, 0, new int[7]);
    }

    // 순열
    static void permutation(boolean[] visited, int cnt, int[] ord_arr){
        if(cnt == 7){
            if(check(ord_arr) && check_num(ord_arr)){
                print(ord_arr);
                System.exit(0);
            }
            return;

        }


        for(int i = 0; i < 9; i++){
            if(!visited[i]){
                visited[i] = true;
                ord_arr[cnt] = arr[i];
                permutation(visited, cnt + 1, ord_arr);
                visited[i] = false;

            }
        }


    }

    static void combination(int start, int cnt, int[] ord_arr){
        if(cnt == 7){
            if (check_num(ord_arr)) {
                print(ord_arr);
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            ord_arr[cnt] = arr[i];
            combination(i+1, cnt + 1, ord_arr);
        }
    }


    static boolean check(int[] ord_arr){
        for(int i = 1; i < 7; i++){
            if(ord_arr[i] < ord_arr[i-1]) return false;
        }
        return true;
    }

    static boolean check_num(int[] ord_arr){
        int num = 0;
        for(int i = 0; i < 7; i++){
            num += ord_arr[i];
        }
        if(num == 100) return true;
        return false;
    }

    static void print(int[] ord_arr){
        for(int num : ord_arr){
            System.out.println(num);
        }
    }

}
