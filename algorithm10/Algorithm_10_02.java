package algorithm10;

import java.util.Scanner;

// ## 돌다리 건너기 (DP : 동적 프로그래밍) ##
// 피보나치 수열, 메모이제이션
public class Algorithm_10_02 {

    static int[] dy;

    static void Solution(int num){
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= num+1; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        System.out.println(dy[num+1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 돌다리 갯수
        dy = new int[num+2]; // 돌다리가 7개면 8개가 되야 건넜다가 성립됨.

        Solution(num);
    }
}
