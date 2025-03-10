import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: participant){
            if(!map.containsKey(s)){
                map.put(s, 1);
            } else{
                map.put(s, map.get(s)+1);
            }
        }
        
        for(String s: completion){
            map.put(s, map.get(s)-1);
            
            if(map.get(s) == 0){
                map.remove(s);
            }
        }
        
        for(String key: map.keySet()){
            answer = key;
        }
        return answer;
    }
}