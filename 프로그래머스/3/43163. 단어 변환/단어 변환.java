import java.util.*;
class Solution {
    
    static int result = Integer.MAX_VALUE;
    static int len = 0;
    
    public int solution(String begin, String target, String[] words) {
        len = words.length;
        dfs(new boolean[words.length], begin, target, words, 0);
        if(result == Integer.MAX_VALUE) result = 0;
        return result;
    }
    public static void dfs(boolean[] visited, String now, String target, String[] words, int cnt){
        if(now.equals(target)){
            if(result > cnt){
                result = cnt;
                return;
            }
        }

        for (int i = 0; i < len; i++) {
            if(visited[i]) continue;
            if(check(now, words[i])){
                visited[i] = true;
                dfs(visited, words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }

    }

    public static boolean check(String s1, String s2){
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        if(cnt > 1 || cnt == 0) return false;
        return true;
    }
}