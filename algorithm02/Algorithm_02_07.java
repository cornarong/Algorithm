package algorithm02;

import java.util.Scanner;

// ## 점수 계산 ##
// for문의 score[i] 값이 0이면 temp에 0넣고, 1이면 temp에 1넣는다.
// 값이 0일 경우 자동 초기화, 값이 1부터 1씩 누적
// for문이 한번씩 돌 떄마다 마지막에 temp값을 결과 result에 누적시킨다.
public class Algorithm_02_07 {

    static void Solution(int num, int[] score){

        int temp = 0,  result = 0;
        for (int i = 0; i < num; i++) {
            if(score[i] == 0){
                temp = 0;
            }else{
                temp ++;
            }
           result += temp;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] score = new int[num];
        for (int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
        }
        Solution(num,score);
    }
}
