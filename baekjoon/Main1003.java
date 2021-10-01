package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ## 피보나치 함수 (다이나믹 프로그래밍) ##
// https://www.acmicpc.net/problem/1003

public class Main1003 {

    public static void main(String[] args) throws IOException {

        // (시간초과 수정) Scanner -> BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        int[][] arr = new int[41][2];
        for (int i = 0; i < testCnt; i++) {
            int n = Integer.parseInt(br.readLine());

            arr[0][0] = 1;
            arr[0][1] = 0;
            arr[1][0] = 0;
            arr[1][1] = 1;

            if(arr[n][0] == 0 && arr[n][1] == 0) {
                for (int j = 2; j <= n; j++) {
                    arr[j][0] = arr[j - 1][0] + arr[j - 2][0];
                    arr[j][1] = arr[j - 1][1] + arr[j - 2][1];
                }
            }
            System.out.println(arr[n][0] + " " + arr[n][1]);
        }
    }
}
