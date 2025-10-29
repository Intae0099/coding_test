class Solution {
    
    static int answer;
    static int len;
    public int solution(int[] numbers, int target) {
        answer = 0;
        len = numbers.length;
        
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int idx, int sum){
        if(idx >= len){
            if(sum == target) answer++;
            return;
        }
        
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
    
    
}