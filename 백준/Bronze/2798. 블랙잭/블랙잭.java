import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		result = 0;
		recur(0, 0, 0);
		System.out.println(result);
		
	}
	private static void recur(int idx, int cnt, int sum) {
		if (cnt == 3) {
			if(sum <= M && result < sum) {
				result = sum;
			}
			return;
		}
		if(idx >= N) {
			return;
		}
		
		if(sum > M) {
			return;
		}
		
		recur(idx + 1, cnt + 1, sum + arr[idx]);
		recur(idx + 1, cnt, sum);
		
	}

}
