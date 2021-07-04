package algorithm06;

import java.util.Scanner;

// ## 버블 정렬 ##
// 버블 정렬 : 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
//           인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환한다.
//           선택 정렬과 기본 개념이 유사하다.

public class Algorithm_06_02 {

    static void Solution(int n, int[] arr){

        // 방법 1
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // 방법 2
        /*while (n != 2){
            for (int j = 0; j < n-1; j++) {
                int temp = arr[j];
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            n--;
        }*/

        for(int x : arr) System.out.printf(x+" ");


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution(n, arr);
    }
}
