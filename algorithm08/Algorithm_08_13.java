package algorithm08;

import java.util.Scanner;

// ## 섬나라 아일랜드(DFS 활용) ##
// ## 섬나라 아일랜드(BFS 활용 - 주석처리) ##

public class Algorithm_08_13 {
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0, -1, 1,1,-1};
    static int[] dy = {0, 0, -1, 1, 1, -1,1,-1};

    static void DFS(Point point){
        for (int i = 0; i < 8; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= n - 1 && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(new Point(nx, ny));
            }
        }
    }

    static void Solution(){
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1){
                    board[i][j] = 0;
                    DFS(new Point(i,j));
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        Solution();
    }
}

/*
public class Main{
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int[][] board;
    static int[][] ch;
    static int[] dx = {-1, 1, 0, 0, -1, 1,1,-1};
    static int[] dy = {0, 0, -1, 1, 1, -1,1,-1};
    static Queue<Point> Q = new LinkedList<>();
    static int result = 0;

    static void BFS(int x, int y){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                if(board[i][j] == 1){
                    Q.offer(new Point(i,j));
                    result++;
                }
                while(!Q.isEmpty()){
                    Point temp = Q.poll();
                    for (int k = 0; k < 8; k++) {
                        int nx = temp.x + dx[k];
                        int ny = temp.y + dy[k];
                        if(nx>=0 && nx<=n-1 && ny>=0 && ny<=n-1 && board[nx][ny] == 1){
                            Q.offer(new Point(nx, ny));
                            board[nx][ny] = 0;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        BFS(0, 0);
        System.out.println(result);
    }
}*/
