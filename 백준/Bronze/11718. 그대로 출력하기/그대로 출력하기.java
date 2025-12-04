import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word;
        StringBuilder sb = new StringBuilder();
        while((word = br.readLine()) != null){
            sb.append(word).append("\n");
        }
        System.out.println(sb);

    }
}
