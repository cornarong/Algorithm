package algorithm08;

import java.util.Scanner;

// ## 조합 구하기(DFS) ##
public class Algorithm_08_09 {

    static int n; // n개의 정수에서
    static int m; // m개를 뽑는다.
    static int combi[]; // 각 조합을 담을 배열

    static void DFS(int l, int s){
        if(l == m){
            for(int x : combi) System.out.printf(x+" ");
            System.out.println();
        }else{
            for (int i = s; i <= n; i++) { // s는 시작 index
                // 조합배열 combi[해당레벨l] = i(시작번호s)
                combi[l] = i;
                DFS(l+1,i+1); // l1 증가, s1증가
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        DFS(0,1);
    }
}
