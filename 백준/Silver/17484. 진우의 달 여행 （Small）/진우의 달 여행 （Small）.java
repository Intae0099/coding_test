import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3]; // [행][열][이전 방향]
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        // 첫 줄 초기화
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = arr[0][j];
            }
        }

        for (int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++){
                for(int d = 0; d < 3; d++){
                    int PrevJ = j + (d-1);
                    if(PrevJ < 0 || PrevJ >= M) continue;
                    for(int PrevD = 0; PrevD < 3; PrevD++){
                        if(d == PrevD) continue;
                        if(dp[i-1][PrevJ][PrevD] != Integer.MAX_VALUE){
                            dp[i][j][d] = Math.min(dp[i][j][d], dp[i-1][PrevJ][PrevD] + arr[i][j]);
                        }
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                result = Math.min(result, dp[N - 1][j][d]);
            }
        }

        System.out.println(result);
    }
}
