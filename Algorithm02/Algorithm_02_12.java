package Algorithm02;

import java.util.Scanner;

// ## 멘토링 ##
// 완전탐색 : 컴퓨터의 빠른 계산 능력을 이용하여 가능한 경우의 수를 일일이 나열하면서 답을 찾는 방법
public class Algorithm_02_12 {

    static void Solution(int num1, int num2, int[][] score){


        // (1,1) (1,2)
        int t1 = 0;
        int t2 = 0;
        int cnt = 0;
        int result = 0;
        for (int i = 1; i < num1+1; i++) {
            for (int j = 1; j < num1+1; j++) {
                for (int k = 0; k < num2; k++) {
                    for (int l = 0; l < num1; l++) {
                        if(i == score[k][l]) t1 = l;
                        if(j == score[k][l]) t2 = l;
                        }
                    if(t1 < t2) cnt++;
                    }
                if(cnt == num2) result++;
                cnt=0;
                }
            }
        System.out.println(result);


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt(); // 학생수
        int num2 = sc.nextInt(); // 시험수
        int[][] score = new int[num2][num1];
        for (int i = 0; i < num2; i++) {
            for (int j = 0; j < num1; j++) {
                score[i][j] = sc.nextInt();
            }
        }
        Solution(num1,num2,score);

    }

}
