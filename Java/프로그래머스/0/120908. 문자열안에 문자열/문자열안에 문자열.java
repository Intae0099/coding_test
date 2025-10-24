import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        boolean flag = false;
        
        int length1 = str1.length();
        int length2 = str2.length();
        
        for(int i = 0; i <= length1 - length2; i++){
            if(str1.charAt(i) == str2.charAt(0)){
                boolean check = true;
                for(int j = 1; j < length2; j++){
                    if(str1.charAt(i + j) != str2.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    flag = true;
                    break;
                }
            }
        }
        
        return flag ? 1 : 2;
    }
}