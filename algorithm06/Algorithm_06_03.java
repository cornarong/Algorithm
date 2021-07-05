package algorithm06;

import java.util.Scanner;

// ## 삽입 정렬 ##
// 2중 for문 사용
// 외부 for문은 시작은 1; i<n 까지0; i++; (내부 for문에서 처음에 0과 비교하기 위함)
// * 외부 for문 첫줄에 temp = arr[i]선언. => temp가 자기 자리를 찾으러 내부 for문으로 탐험 시작.
// 내부 for문은 시작은 i-1; j >=0 까지; 1--;
// * 비교 시 temp가 작으면 바꾸고 크면 break;

public class Algorithm_06_03 {

    static void Solution(int n, int[] arr){

        // 6
        // 11 7 5 6 10 9

        // * Tip : 작으면 바꾸고 크면 멈춰라.

        for (int i = 1; i < n; i++) {
            int temp = arr[i]; // temp가 자리를 찾아가는 방식.
            for (int j = i-1; j >= 0; j--) {
                if(temp < arr[j]){
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
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
