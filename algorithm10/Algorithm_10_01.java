package algorithm10;

import java.util.Scanner;

// ## 계단 오르기 (DP : 동적 프로그래밍) ##
// 피보나치 수열, 메모이제이션
public class Algorithm_10_01 {

    static int[] dy;

    static void Solution(int num){
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= num; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        System.out.println(dy[7]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        dy = new int[num+1];

        Solution(num);
    }
}
