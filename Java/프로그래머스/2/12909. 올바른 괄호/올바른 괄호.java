import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char next : s.toCharArray()){
            if(stack.isEmpty()){
                if(next == ')') return false;
                stack.push(next);
                continue;
            }
            
            if(next == ')'){
                if(stack.peek() == '(') stack.pop();
            }
            else stack.push(next);
            
            
        }
        
        if(!stack.isEmpty()) return false;
        return true;
    }
}