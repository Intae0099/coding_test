import java.io.*;
import java.util.*;

public class Main {

    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int idx, size;

        private int readByte() throws IOException {
            if (idx >= size) {
                size = System.in.read(buffer);
                idx = 0;
                if (size <= 0) return -1;
            }
            return buffer[idx++];
        }

        int nextInt() throws IOException {
            int c, n = 0;
            while ((c = readByte()) <= ' ') if (c == -1) return -1;
            boolean neg = (c == '-');
            if (neg) c = readByte();
            do n = n * 10 + c - '0';
            while ((c = readByte()) >= '0' && c <= '9');
            return neg ? -n : n;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int K = fr.nextInt();

        int[][] jewel = new int[N][2];
        for (int i = 0; i < N; i++) {
            jewel[i][0] = fr.nextInt(); // 무게
            jewel[i][1] = fr.nextInt(); // 가치
        }

        int[] bag = new int[K];
        for (int i = 0; i < K; i++) bag[i] = fr.nextInt();

        Arrays.sort(jewel, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            int cur = bag[i];
            while (idx < N && jewel[idx][0] <= cur) {
                pq.add(jewel[idx][1]);
                idx++;
            }
            if (!pq.isEmpty()) result += pq.poll();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Long.toString(result));
        bw.flush();
    }
}
