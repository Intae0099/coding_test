import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int N = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int x = set.size();
        int answer = Math.min(N, x);
        return answer;
    }
}