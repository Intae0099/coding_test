import java.util.*;
import java.io.*;

public class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        if(str1.length() < str2.length()) System.out.println("no");
        else{
            System.out.println("go");
        }
    }
}