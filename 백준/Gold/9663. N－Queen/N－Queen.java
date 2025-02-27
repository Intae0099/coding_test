import java.io.*;
import java.util.*;

public class Main {

	static int N, result;
	static boolean[] col, slash, bSlash; // 같은 열, 대각선(/), 대각선(\)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result = 0;
		col = new boolean[N+1];
		slash = new boolean[2 * N + 1];
		bSlash = new boolean[2 * N];
		
		setQueens(1);
		System.out.println(result);
	}
	
	static void setQueens(int rowNo) {
		
		if(rowNo > N) {
			result += 1;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			//가지치기
			if(!isAvailable(rowNo, i)) continue;
			
			col[i] = slash[rowNo + i] = bSlash[(rowNo - i + N)] = true;
			setQueens(rowNo+1);
			col[i] = slash[rowNo + i] = bSlash[(rowNo - i + N)] = false;
		}
	}

	private static boolean isAvailable(int rowNo, int i) {
		return !col[i] && !slash[rowNo+i] && !bSlash[rowNo-i + N];
	}
	
	static void print() {
		System.out.println(Arrays.toString(col));
	}
}
