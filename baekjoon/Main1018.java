package baekjoon;

import java.io.*;

// ## 체스판 다시 칠하기 (브루트포스 알고리즘) ##
// https://www.acmicpc.net/problem/1018
// https://cornarong.tistory.com/64 - 개인 블로그 정리

public class Main1018 {

    /* 구한 좌표를 기준으로 시작 "W", 시작 "B" 총 2번 */
    public int find(int findX, int findY, String[][] arr){
        int minCnt = Integer.MAX_VALUE;
        int row = 0;
        for (int i = 0; i < 2; i++) {
            int cnt = 0;
            for (int j = findX; j <= findX+7; j++) {
                for (int k = findY; k <= findY+7; k++) {
                    if(row == 0){
                        if(k % 2 == 0 && arr[j][k].equals("B")) cnt++;
                        else if(k % 2 != 0 && arr[j][k].equals("W")) cnt++;
                    }else{
                        if(k % 2 == 0 && arr[j][k].equals("W")) cnt++;
                        else if(k % 2 != 0 && arr[j][k].equals("B")) cnt++;
                    }
                }
                row = (row == 0) ? 1 : 0;
            }
            minCnt = Math.min(minCnt, cnt);
            row++;
        }
        return minCnt;
    }

    public static void main(String[] args) throws IOException {

        Main1018 T = new Main1018();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력값 배열 만들기 */
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                arr[i][j] = String.valueOf(temp.charAt(j));
            }
        }

        /* 8x8로 만들 수 있는 시작좌표의 모든 경우의 수 구하기 */
        int answer = Integer.MAX_VALUE;
        int x = 0;
        while(x+7 < n){
            int y = 0;
            while(y+7 < m){
                answer = Math.min(answer, T.find(x, y, arr));
                y++;
            }
            x++;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        br.close();
        bw.close();
    }
}
