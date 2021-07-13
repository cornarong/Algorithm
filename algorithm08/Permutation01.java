package algorithm08;

import java.util.Scanner;

// ## 중복 순열 구하기(DFS) ##
public class Permutation01 {
    static int n; // 1부터 n까지의 양수
    static int m; // m번 뽑는다. -> level0과 level1에서 만들고 level2에서 출력
    static int[] arr; // m크기의 배열

    static void DFS(int level) {

        if(level == m){
            for(int x : arr) System.out.printf(x+" ");
            System.out.println();
            return;
        }else{
            for (int i = 1; i <= n; i++) {
                arr[level] = i;
                DFS(level+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        DFS(0);
    }
}

