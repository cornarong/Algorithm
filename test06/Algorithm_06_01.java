package test06;

import java.util.Scanner;

// ## 선택 정렬 ##
// 선택정렬 : 기준이되는 수와 나머지수를 비교하여 가장 낮은수를 제일 앞으로 보내는 정렬

// 선택 정렬은 첫 번째 자료를 두 번째 자료부터 마지막 자료까지 차례대로 비교하여 가장 작은 값을 찾아 첫 번째에 놓고,
// 두 번째 자료를 세 번째 자료부터 마지막 자료까지와 차례대로 비교하여 그 중 가장 작은 값을 찾아 두 번째 위치에 놓는 과정을 반복하며 정렬을 수행한다.
// 1회전을 수행하고 나면 가장 작은 값의 자료가 맨 앞에 오게 되므로 그 다음 회전에서는 두 번째 자료를 가지고 비교한다.
// 마찬가지로 3회전에서는 세 번째 자료를 정렬한다.

public class Algorithm_06_01 {

    static void Solution(int n, int[] arr){


        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = arr[i];
                if(arr[i] > arr[j]){
                    arr[i] = arr[j];
                    arr[j] = temp;
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
