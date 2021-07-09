package algorithm07;

import java.util.Scanner;

// ## 재귀함수를 이용한 피보나치수열 (메모이제이션 활용) ##
public class Algorithm_07_04 {

    static int[] fibo; // 배열에 구한값을 담아둔다.
    public int DFS(int n) {
        if(fibo[n] > 0) return fibo[n]; // fino[n] 0보다 크다면 이미 구한 값이다.
        if(n==1 || n==2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-2)+DFS(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Algorithm_07_04 T = new Algorithm_07_04();
        int n = sc.nextInt();
        fibo = new int[n+1]; // 인덱스 번호로 필요하기 때문에 +1 , 0번은 필요 없다.
        T.DFS(n);
        for (int i = 1; i <= n; i++){
            System.out.printf(fibo[i] + " ");
        }
    }
}
