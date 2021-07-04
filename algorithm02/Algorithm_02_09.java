package algorithm02;

import java.util.Scanner;

// ## 격자판 최대합 ##
// 2차원배열로 초기화 , 2중 for문 사용
// Math.max 사용 (가장 큰 값 유지)
public class Algorithm_02_09 {

    static void Solution(int num, int[][] AA){

        int temp = 0;
        int sum1 = 0, sum2 = 0;

        // 행과 열
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sum1 += AA[i][j]; // 행
                sum2 += AA[j][i]; // 열
            }
            temp = Math.max(temp,sum1);
            temp = Math.max(temp,sum2);
            sum1 = 0;
            sum2 = 0;
        }

        //좌 대각선
        for (int i = 0; i < num; i++) {
            sum1 += AA[i][i];
        }
        //우 대각선
        for (int i = 0; i < num; i++) {
            sum2 += AA[i][num-i-1];
        }
        temp = Math.max(temp,sum1);
        temp = Math.max(temp,sum2);

        System.out.println(temp);

    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] AA = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                AA[i][j] = sc.nextInt();
            }
        }
        Solution(num,AA);
    }
}
