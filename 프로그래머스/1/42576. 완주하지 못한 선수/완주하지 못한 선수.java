import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> user = new HashMap<>();
        
        for(String word : participant){
            user.put(word, user.getOrDefault(word, 0) + 1);
        }
        
        for(String complet : completion){
            user.put(complet, user.get(complet) - 1);
        }
        
        String answer = "";
        for(String temp : user.keySet()){
            if(user.get(temp) > 0) {
                answer = temp;
                }
        }
        return answer;
    }
}