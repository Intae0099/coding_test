import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String my_string) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(char temp : my_string.toCharArray()){
            if(temp - '0' >= 0 && temp - '0' <= 9){
                answer.add(temp - '0');
            }
        }
        Collections.sort(answer);
        
        return answer;
    }
}