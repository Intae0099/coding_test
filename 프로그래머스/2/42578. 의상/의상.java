import java.util.*;
class Solution {
    
    static int result = 0;
    static ArrayList<Integer> n_list;
    public int solution(String[][] clothes) {
		HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
			if(hash.containsKey(clothes[i][1])) {
				hash.put(clothes[i][1], hash.get(clothes[i][1]) + 1);
			}
			else {
				hash.put(clothes[i][1], 1);
			}
		}
        n_list = new ArrayList<>();
	    
        
        
        for (int i : hash.values()) {
			n_list.add(i);
		}
        
        result = 0;
        recur(0, 1);
        
        return result - 1;
        
        
        
        
    }
    public static void recur(int idx, int sum) {
		if(idx == n_list.size()) {
			result += sum;
			return;
		}
		
		recur(idx + 1, sum * n_list.get(idx));
		recur(idx + 1, sum);
		
	}
}