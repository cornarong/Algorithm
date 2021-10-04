package baekjoon;

// ## 1로 만들기 (다이나믹 프로그래밍) ##
// https://www.acmicpc.net/problem/1463
// DP 이용.
// 주석 -> 재귀함수 이용.
// https://cornarong.tistory.com/66 - 개인 블로그 정리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {

    // 재귀함수 풀이
//    static int minCnt = Integer.MAX_VALUE;
    static int[] dp;

    // 재귀함수 풀이
    /*static void DFS(int n, int cnt){
        if(minCnt <= cnt) return;
        if(n == 1){
            minCnt = Math.min(minCnt, cnt);
        }else{
            if(n%2 == 0) DFS(n/2, cnt+1);
            if(n%3 == 0) DFS(n/3, cnt+1);
            DFS(n-1, cnt+1);
        }
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        // 재귀함수 풀이
//        DFS(n, 0);

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int A = Integer.MAX_VALUE, B = Integer.MAX_VALUE, C = Integer.MAX_VALUE;
            if(i%2 == 0){
                if(i/2 == 1) A = 1;
                else A = dp[i/2] + 1;
            }
            if(i%3 == 0){
                if(i/3 == 1) B = 1;
                else B = dp[i/3] + 1;
            }
            C = dp[i-1] + 1;
            dp[i] = Math.min(A,Math.min(B,C));
        }

        // 재귀함수 풀이
//        System.out.println(minCnt);
        System.out.println(dp[n]);
    }
}