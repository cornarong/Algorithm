import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{

    static int n;
    static int[][] board;
    static int[][] ch;
    static int[] dx = {-1, 1, 0, 0, -1, 1,1,-1};
    static int[] dy = {0, 0, -1, 1, 1, -1,1,-1};
    static Queue<Point> Q = new LinkedList<>();

    static void DFS(int x, int y){

        if(){

        }else{
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                }
            }

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>=0 && nx<=n && ny>=0 && ny<=n && board[nx][ny] == 1){
                    DFS(nx, ny);
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
        DFS(0, 0);

    }
}