package algorithm08;

import java.util.Scanner;

// ## 순열 구하기(DFS) ##
public class Permutation02 {
    // 10이하의 n개의 자연수가 주어지면 이 중 m개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
    // 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
    // 두 번쨰 줄에 N개의 자연수가 오름차순으로 주어집니다.
    // 첫 번째 줄에 결과를 출력합니다.
    // 출력순서는 사전순으로 오름차순으로 출력합니다.
    static int n; //
    static int m; //
    static int[] arr; // 실제 주어진 자연수 값 배열
    static int[] ch; // n개의 자연수 크기의 배열 , 0 또는 1로 입력받은 자연수 값을 사용 했는지 안했는지 여부로 사용 (중복방지)
    static int[] pm; // level을 index로 사용하여 해당 level의 구한 값을 넣어주게 할것임. -> ex) 출력 시 3 6과 6 3

    static void DFS(int level){
        if(level == m){
            for(int x : pm) System.out.printf(x+" ");
            System.out.println();
            return;
        }else{
            for (int i = 0; i < n; i++) {
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[level] = arr[i];
                    DFS(level+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n개의 자연수 3
        m = sc.nextInt(); // 뽑을 횟수 2
        arr = new int[n]; //
        ch = new int[n]; //
        pm = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0);
    }
}
