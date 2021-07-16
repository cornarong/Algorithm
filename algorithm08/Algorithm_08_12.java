package algorithm08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ## 토마토(BFS 활용) ##
// https://cornarong.tistory.com/20

public class Algorithm_08_12 {

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Point> Q = new LinkedList<>();
    static int n; // 가로 칸의 수
    static int m; // 세로 칸의 수
    static int[][] board; // 토마토 상태 배열
    static int[][] dis; // 토마토 상태변화 일자 배열
    static int[] dx = {-1, 1, 0, 0}; // 상 하
    static int[] dy = {0, 0, -1, 1}; // 좌 우

    static void BFS(int x, int y){
        while (!Q.isEmpty()){
            Point temp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx>=1 && nx<=n && ny>=1 && ny<=m && board[nx][ny]==0){
                    Q.offer(new Point(nx,ny));
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 상자의 가로 칸 수
        n = sc.nextInt(); // 상자의 세로 칸 수
        board = new int[n+1][m+1];
        dis = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1){
                    Q.offer(new Point(i, j));
                }
            }
        }
        BFS(1,1);
        boolean flag = true;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(board[i][j] == 0){
                    flag = false;
                    break;
                }
            }
        }
        if(flag==true){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    result = Math.max(dis[i][j],result);
                }
            }
        }else{
            result = -1;
        }
        System.out.println(result);
    }
}