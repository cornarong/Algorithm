package algorithm06;

import java.util.Arrays;
import java.util.Scanner;

// ## 이분검색 (이분탐색) ##
// 이분검색은 무조건 정렬이 되어 있어야 가능하다.
// 이분검색 하면 left,middle,right 생각하라!
// left = 0 , right = n-1 , middle = (lt+rt)/2

public class Algorithm_06_08 {

    void Solution(int n, int m, int[] arr){

        // 이분검색은 무조건 "정렬"이 되어 있어야 가능하다. (오름 or 내림)
        Arrays.sort(arr);
        int result = 0;
        int left = 0, right = n-1;
        while(left <= right){ // 작거나 같을 떄까지 돌린다.
            int middle = (left+right)/2;
            // 찾았다. -> brake;
            if(arr[middle] == m) {
                result = middle+1;
                break;
            // middle보다 m이 작다. -> right를 좌측으로 이동.
            }else if(arr[middle] > m) {
                right = middle-1;
                middle = (left+right)/2;
            // middle보다 m이 크다. -> left를 우축으로 이동.
            }else{
                left = middle+1;
                middle = (left+right)/2;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Algorithm_06_08 T = new Algorithm_06_08();
        T.Solution(n, m, arr);


    }
}
