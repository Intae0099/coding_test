import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        
        answer = (set.size() >= nums.length / 2) ? nums.length/2 : set.size();
        return answer;
    }
}