import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> num_set = new HashSet<>();
        for(int num : nums){
            num_set.add(num);
        }
        
        int length = nums.length / 2;
        
        int answer = 0;
        
        if(num_set.size() <= length) answer = num_set.size();
        else answer = length;
        
        return answer;
    }
}