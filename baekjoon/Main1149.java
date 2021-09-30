package baekjoon;

import java.util.Scanner;

// ## RGB거리 (다이나믹 프로그래밍) ##
// https://www.acmicpc.net/problem/1149

public class Main1149 {

    static int n;

    int find(int[][] dp){

        for (int i = 1; i < n; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            dp[i][0] = sc.nextInt();
            dp[i][1] = sc.nextInt();
            dp[i][2] = sc.nextInt();
        }
        Main1149 T = new Main1149();
        int answer = T.find(dp);
        System.out.println(answer);
    }
}
