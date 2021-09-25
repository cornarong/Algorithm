package baekjoon;

import java.util.Scanner;

// ## 블랙잭 (브루트포스 알고리즘) ##
// https://www.acmicpc.net/problem/2798

public class Main2798 {

    static int result = Integer.MIN_VALUE;

    public void DFS(int n, int m, int[] arr, int[] visited, int sum, int l){
        if(sum > m) return;
        if(l == 3){
            if(result < sum) result = sum;
            return;
        }else{
            for(int i=0; i<n; i++){
                if(visited[i] == 0){
                    visited[i] = 1;
                    sum = sum + arr[i];
                    DFS(n,m,arr,visited, sum,l+1);
                    sum = sum - arr[i];
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] visited = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Main2798 T = new Main2798();
        T.DFS(n, m, arr, visited, 0, 0);
        System.out.println(result);

    }
}
