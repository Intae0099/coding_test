import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        char[] alpha = my_string.toCharArray();
        for(int i = alpha.length-1; i >= 0; i--){
            sb.append(alpha[i]);
        }
            
        return sb.toString();
    }
}