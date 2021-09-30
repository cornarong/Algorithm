package baekjoon;

// ## 피보나치 수 5 (수학, 구현, 다이나믹 프로그래밍) ##
// https://www.acmicpc.net/problem/10870

import java.util.Scanner;

public class Main10870 {

    // dy배열에 값을 넣어서 return 해줌으로 써, 조건 dy[n] != 0을 사용할 수 있으며
    // 이 조건은 이미 구한(방문한) 노드의 값은 재귀를 호출할 필요 없이 바로 꺼내 쓸 수 있다.

    int DFS(int n, int[] dy){
        if(n == 1)  return dy[n] = 1;
        if(n == 0) return dy[n] = 0;
        if(dy[n] != 0) {
            return dy[n];
        }else{
            return dy[n] = DFS(n-1, dy) + DFS(n-2, dy);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dy = new int[n+1]; // 메모이제이션 활용

        Main10870 T = new Main10870();
        T.DFS(n, dy);
        System.out.println(dy[n]);
    }
}
