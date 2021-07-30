package algorithm10;

import java.util.Scanner;

// ## 최대부분증가수열 (LIS) ##
public class Algorithm_10_03 {

    static int num;
    static int[] arr;
    static int[] dy;
    static int result = 0;

    static void LIS(){
        dy[0] = 1;
        for (int i = 1; i < num; i++) {
            int temp = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] > arr[j] && temp < dy[j]){
                        temp = dy[j];
                    }
                }
            dy[i] = temp+1; // temp자체가 0일 경우 그냥 1로 반환.
            result = Math.max(result, dy[i]);
            }
        System.out.println(result);
        }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        arr = new int[num]; // 입력값배열
        dy = new int[num]; // DP배열
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        LIS();
    }
}
