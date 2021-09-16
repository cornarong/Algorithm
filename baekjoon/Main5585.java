package baekjoon;

import java.util.Scanner;

// 거스름돈 (그리디 알고리즘 - 기초)
// https://www.acmicpc.net/problem/5585

public class Main5585 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = {500,100,50,10,5,1};
        int pay = sc.nextInt();

        int rest = 1000 - pay;

        int cnt = 0;
        for(int i = 0; i < coins.length; i++){
            if(rest >= coins[i]){
                cnt += rest / coins[i];
                rest = rest - (rest/coins[i]) * coins[i];
            }
        }
        System.out.println(cnt);
    }
}
