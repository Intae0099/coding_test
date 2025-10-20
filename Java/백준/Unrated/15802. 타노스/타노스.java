import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        if(temp.equals("이게왜정답?")) System.out.println(1);
        else System.out.println(0);
    }
}