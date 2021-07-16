package algorithm08;

import java.util.Scanner;

// ## 미로탐색(DFS) ##
public class Algorithm_08_10 {

    static int[][] chArr; // 체크배열
    static int sum = 0;
    /*
    DFS(x,y+1); // 상
    DFS(x,y-1); // 하
    DFS(x+1,y); // 좌
    DFS(x-1,y); // 우
    */
    static int[] XTemp = {0, 0, 1,-1}; // 좌우
    static int[] yTemp = {1, -1, 0, 0}; // 상하

    static void DFS(int x, int y){
        if(x == 7 && y == 7){
            sum++;
            return;
        }else {
            for (int i = 0; i < 4; i++) {
                int nx = x+XTemp[i];
                int ny = y+yTemp[i];
                if(nx >=  1 && ny >= 1 && nx <= 7 &&  ny <= 7 && chArr[nx][ny] == 0) {
                    chArr[nx][ny] = 1;
                    DFS(nx,ny);
                    chArr[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        chArr = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                chArr[i][j] = sc.nextInt();
            }
        }
        chArr[1][1] = 1;
        DFS(1,1);
        System.out.println(sum);

    }
}
