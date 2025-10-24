import java.util.*;
class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] temp = my_string.toCharArray();
        Arrays.sort(temp);
        
        StringBuilder sb = new StringBuilder();
        for(char alpha : temp) sb.append(alpha);
        
        
        return sb.toString();
    }
}