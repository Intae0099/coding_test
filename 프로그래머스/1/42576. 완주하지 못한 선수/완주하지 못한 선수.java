import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hash = new HashMap<>();
		
		for (String str : completion) {
			if(! hash.containsKey(str)) {
				hash.put(str, 1);
			}
			else {
				hash.replace(str, hash.get(str) + 1);
			}
		}
		for (String str : participant) {
			if(! hash.containsKey(str) || hash.get(str) == 0) {
				answer = str;
                break;
			}
			else {
				hash.replace(str, hash.get(str) - 1);
			}
		}
        
        return answer;
    }
}