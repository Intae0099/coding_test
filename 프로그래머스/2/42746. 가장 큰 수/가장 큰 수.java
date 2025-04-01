import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        String temp;
        for(int i = 0; i < numbers.length; i++){
            temp = Integer.toString(numbers[i]);
            for(int k = 0; k < temp.length(); k++){
                arr.add((int) temp.charAt(k) - '0');
            }
            
        }
        Collections.sort(arr, Collections.reverseOrder());
        String answer = "";
        for(Integer k : arr){
            answer += Integer.toString(k);
        }
        return answer;
    }
}