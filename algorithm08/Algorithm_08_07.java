package algorithm08;

import java.util.Scanner;

// ## 조합의 경우수 (메모이제이션) ##
public class Algorithm_08_07 {
    static int n;
    static int r;
    static int[][] arr; // 메모이제이션 활용

    public int DFS(int n, int r){
        if(n == r || r == 0){
            return arr[n][r] = 1;
        }else{
            if(arr[n][r] == 0){
                return arr[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
            }else{
                return arr[n][r];
            }
        }
    }
    public static void main(String[] args) {

        Algorithm_08_07 T = new Algorithm_08_07();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n개 중
        r = sc.nextInt(); // r개를 뽑을 경우의 수
        arr = new int[n+1][n+1]; // 메모이제이션을 위한 배열 (입력값 n크기+1)

        // 마지막의 입력 값 5C3의 조합 수를 출력 하게됨.
        System.out.println(T.DFS(n, r));
    }
}
