        import java.util.*;
        import java.io.*;

        public class Main {

            public static int N;
            public static int[][] dp;
            public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                N = Integer.parseInt(br.readLine());
                dp = new int[10001][4];

                dp[1][1] = 1;
                dp[1][2] = 0;
                dp[1][3] = 0;
                dp[2][1] = 1;
                dp[2][2] = 1;
                dp[2][3] = 0;
                dp[3][1] = 1;
                dp[3][2] = 1;
                dp[3][3] = 1;

                for (int i = 4; i < 10001 ; i++) {
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] += dp[i-2][2] + dp[i-2][1];
                    dp[i][3] += dp[i-3][3] + dp[i-3][2] + dp[i-3][1];
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    int ord = Integer.parseInt(br.readLine());
                    sb.append(dp[ord][1] + dp[ord][2] + dp[ord][3]).append("\n");
                }
                System.out.println(sb);
            }
        }


        /*

        1 : 1
        2 : 1+1, 2
        3 : 1+1+1, 1+2, 3
        4 : 1+1+1+1, 1+1+2, 2+2, 1+3

        dp[4-1][1] : 1 : dp[3][1] : 1
        dp[4-2][2] : 1 : dp[2][2] : 1
        dp[4-2][1] : 1 : dp[2][1] : 1
        dp[4-3][3] : 0 : dp[1][3] : 0
        dp[4-3][1] : 1 : dp[1][1] : 1

        5 : 1+1+1+1+1, 1+1+1+2, 1+2+2, 3+2, 1+1+3

        dp[5-1][1] : 1
        dp[5-2][2] : 1
        dp[5-2][1] : 1
        dp[5-3][3] : 0
        dp[5-3][1] : 1


        6 : 1+1+1+1+1+1, 1+1+1+1+2, 1+1+2+2, 2+2+2, 1+1+1+3, 1+2+3, 3+3

        dp[6-1][1] : 1
        dp[6-2][2] : 2
        dp[6-2][1] : 1
        dp[6-3][3] : 1
        dp[6-3][1] : 1

        7 : 1+1+1+1+1+1+1, 1+1+1+1+1+2, 1+1+1+2+2, 1+2+2, 1+1+2+3, 2+2+3, 1+3

        dp[7-1][1] : 1
        dp[7-2][2] = 2
        dp[7-2][1] = 1
        dp[7-3][3] = 1
        dp[7-3][2] = 1
        dp[7-3][1] = 1





         */