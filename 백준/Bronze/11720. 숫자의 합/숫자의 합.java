import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int result = 0;
        for (char alpha : word.toCharArray()){
            result += (alpha - '0');
        }

        System.out.println(result);
    }
}
