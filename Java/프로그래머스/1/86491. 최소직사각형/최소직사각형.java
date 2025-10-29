class Solution {
    public int solution(int[][] sizes) {
        int x_max = 0;
        int y_max = 0;
        
        for(int[] size : sizes){
            int temp_max = Math.max(size[0], size[1]);
            int temp_min = Math.min(size[0], size[1]);
            x_max = Math.max(x_max, temp_max);
            y_max = Math.max(y_max, temp_min);
        }
        
        int answer = x_max * y_max;
        return answer;
    }
}