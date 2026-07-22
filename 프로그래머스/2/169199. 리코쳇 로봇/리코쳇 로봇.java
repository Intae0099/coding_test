import java.util.*;

class Solution {
    
    static class Node{
        int x, y, dist;
        Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    static int W, H, goal_x, goal_y;
    // -1 : 장애물, 0 : 길, 1 : 목표
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(String[] board) {
        H = board.length;
        W = board[0].length();
        
        int start_x = 0;
        int start_y = 0;
        map = new int[H][W];
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(board[i].charAt(j) == 'D') map[i][j] = -1;
                else if(board[i].charAt(j) == 'G'){
                    goal_x = i;
                    goal_y = j;
                }
                else if(board[i].charAt(j) == 'R'){
                    start_x = i;
                    start_y = j;
                }
            }
        }
        
        if(check_goal()){
            return -1;
        }
    
        int answer = move(start_x, start_y);
        return answer;
    }
    
    public static int move(int start_x, int start_y){
        boolean[][] visited = new boolean[H][W];
        visited[start_x][start_y] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(start_x, start_y, 0));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int now_x = now.x;
            int now_y = now.y;
            int now_dist = now.dist;
            if(now_x == goal_x && now_y == goal_y) return now_dist;
            
            for(int d = 0; d < 4; d++){
                int nx = now_x;
                int ny = now_y;
                
                while(true){
                    if(check(nx + dx[d], ny + dy[d])) break;
                    nx += dx[d];
                    ny += dy[d];
                }
                if(!visited[nx][ny]){
                    q.add(new Node(nx, ny, now_dist + 1));
                    visited[nx][ny] = true;
                }
                
            }
        }
        
        return -1;
    }
    
    public static boolean check(int nx, int ny){
        return nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == -1;
    }
    
    public static boolean check_goal(){
        for(int d = 0; d < 4; d++){
            int nx = goal_x + dx[d];
            int ny = goal_y + dy[d];
            if(check(nx, ny)) return false;
            if(map[nx][ny] == -1) return false;
        }
        
        return true;
    }
}