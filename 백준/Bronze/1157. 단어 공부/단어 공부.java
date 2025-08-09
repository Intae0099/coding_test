import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        word = word.toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();
        int result_max = 0;
        for(char c : word.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
            result_max = Math.max(result_max, map.get(c));
        }

        int cnt = 0;
        char result = '?';
        for(char c : map.keySet()){
            if(map.get(c) == result_max){
                result = c;
                cnt ++;
            }
        }

        if(cnt > 1){
            System.out.println("?");
        }
        else{
            System.out.println(result);
        }



    }


}
