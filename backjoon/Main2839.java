package backjoon;

import java.util.Scanner;

// ## 설탕 배달 (수학, 다이나믹 프로그래밍, 그리디 알고리즘) ##
// https://www.acmicpc.net/problem/2839

public class Main2839 {

    public int solution(int N){
    int threeCnt = 0;
        while(true){
            if(N % 5 == 0){
                return threeCnt + N/5;
            }else{
                N = N-3;
                threeCnt += 1;
            }
            if(N == 0) return threeCnt;
            if(N < 0) break;

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Main2839 s = new Main2839();
        System.out.println(s.solution(N));
    }
}
