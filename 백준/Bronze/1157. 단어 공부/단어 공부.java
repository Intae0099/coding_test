import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        word = word.toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();


        int[] alpha = new int[26];
        char result = '?';
        for(char c : word.toCharArray()){
            alpha[c - 'A'] ++;
        }

        int result_max = 0;

        for(int i = 0; i < 26; i++){
            if(result_max < alpha[i]){
                result_max = alpha[i];
                result = (char) ('A' + i);
            }
            else if (result_max == alpha[i]){
                result = '?';
            }
        }

        System.out.println(result);


    }


}
