package algorithm07;

import java.util.Scanner;

// ## 부분 집합 구하기(DFS) ##
// 자연수 n이 주어지면 1부터 n까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
// 단, 공집합은 출력하지 않는다.

// 입력 예제
// 3
// 출력 예제
// 1 2 3
// 1 2
// 1 3
// 1
// 2 3
// 2
// 3

public class Algorithm_07_06 {
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L == n+1){ // DFS함수의 인자값 L이 입력값 n보다 크면 종료 시점은 참이된다.
            for(int i=0; i<=n; i++){
                if(ch[i]==1) System.out.printf(i+" ");
            }
            System.out.println();
        }else{
            ch[L] = 1; // 배열의 (현재 들어온 인자)인덱스를 1으로 만들고 ..
            DFS(L+1); // 왼쪽라인을 태운다.
            // ------------------------------------------------------ //
            ch[L] = 0; // 배열의 (현재 들어온 인자)인덱스를 0으로 만들고 ..
            DFS(L+1); // 오른쪽라인을 태운다.
        }
    }
    public static void main(String[] args) {
        Algorithm_07_06 T = new Algorithm_07_06();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n+1];
        T.DFS(1);
    }
}
