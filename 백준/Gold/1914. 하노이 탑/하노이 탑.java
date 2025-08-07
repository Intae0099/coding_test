import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        BigInteger result = new BigInteger("2");
        sb.append(result.pow(N).subtract(new BigInteger("1"))).append("\n");

        if(N<=20){
            dfs(N, 1, 2, 3);

        }
        System.out.println(sb);


    }

    static void dfs(int n, int start, int mid, int end){
        if(n == 1){
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        dfs(n-1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        dfs(n-1, mid, start, end);
    }


}