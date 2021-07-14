package algorithm08;

import java.util.Scanner;

// ## 수열 추측하기 (이항계수,DFS) ##
class Algorithm_08_08 {
    static int n; // 가장 윗줄의 숫자의 개수 (1 ~ N)
    static int f; // 파스칼 삼각형의 맨 아래 값
    static int[] combiArr; // 이항계수를 사용한 조합수 저장 배열
    static int[] PerArr; // 순열 저장 배열
    static int[] perCh; // 순열 체크 배열
    static int[][] dy; // 조합수 메모이제이션 2차원 배열
    boolean flag = false; // 재귀함수 중단 용도로 사용할 플래그 값

    // 이항계수를 사용하여 조합수를 구한 후 b배열에 담아 둔다.
    public int combi(int n, int r){
        if(dy[n][r] > 0) {
            return dy[n][r];
        }
        if(n==r || r==0) {
            return dy[n][r] = 1;
        } else {
            return dy[n][r]=combi(n-1, r-1)+combi(n-1, r);
        }
    }
    // 재귀함수 DFS()를 사용하여 순열을 구하는 과정속에서
    // 해당 level(여기선 DFS함수의 매개변수 L로 받았다.)을 PerArr배열(순열)과 combiArr배열(조합)의 index로 사용한다.
    // 해당 level에서 순열을 구하는 동시에 기존에 구해놓은 combiArr배열의 같은 index값을 곱하여
    // sum에 누적 시킨값을 다음 재귀함수에 매개변수로 넘긴다.
    // L==n 조건이 완성되는(순열이 한개 완성되는) 순간 누적된 sum값과 f값을 비교한다.
    // 참일 경우 전역변수에 선언된 flag값을 true로 바꾼 후 다음 호출되는 재귀함수는 바로 return시켜서 전부 빠져 나간다.
    public void DFS(int L, int sum){ // L - level , sum - 누적 값
        if(flag) return;
        if(L==n){
            if(sum==f){
                for(int x : PerArr) System.out.print(x+" ");
                flag=true;
            }
        } else{
            for(int i=1; i<=n; i++){
                if(perCh[i]==0){
                    perCh[i]=1;
                    PerArr[L]=i;
                    DFS(L+1, sum+(PerArr[L]*combiArr[L]));
                    perCh[i]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        Algorithm_08_08 T = new Algorithm_08_08();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        PerArr = new int[n];
        combiArr = new int[n];
        perCh = new int[n+1];
        dy = new int[n][n];
        for(int i=0; i<n; i++){
            combiArr[i]=T.combi(n-1, i);
        }
        T.DFS(0, 0);
    }
}