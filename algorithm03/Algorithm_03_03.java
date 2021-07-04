package algorithm03;

import java.util.Scanner;

// ## 최대 매출 ##

// 만약 N=10이면 10일 간의 매출기록이 아래와 같습니다.
// 12 15 11 20 25 10 20 19 13 15
// 연속된 K일 동안의 최대 매출액을 구하는데 이때 K=3이면
// 12 15 (11 20 25) 10 20 19 13 15
// 연속된 3일간의 최대 매출액은 11+20+25=56만원 입니다.

// Sliding Window 사용
// -> 비교를 위한 k값의 합 sum을 초기화 하지 않고 새로운 값을 더하고 처음 값을 뺀다 큐(FIFO)방식 사용.
// * tip : 처음 for문을 사용하여 0번 부터 k번 까지의 합(sum)을 미리 구해놓고 시작한다.

public class Algorithm_03_03 {

    static void Solution(int n, int k, int[] dateArr){

//      예시 입력
//      10 3
//      12 15 11 20 25 10 20 19 13 15

        int sum = 0;
        int result = 0;
        for (int i = 0; i < k; i++) {
            sum += dateArr[i];
        }
        result = sum;
        for (int i = k; i < n; i++) {
            sum += dateArr[i]; // i값(새로 들어올 값)을 더하고
            sum -= dateArr[i-k]; // i-k의 값(현재 배열 기준 첫번 째 값)을 뺀다.
            if(result < sum){
                result = sum;
            }
        }
        System.out.println(result);


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dateArr = new int[n];
        for (int i = 0; i < n; i++) {
            dateArr[i] = sc.nextInt();
        }

        Solution(n,k,dateArr);

    }
}
