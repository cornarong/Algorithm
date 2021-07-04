package Algorithm03;

import java.util.Scanner;

// ## 연속된 자연수의 합 ##
// N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
// 만약 N=15이면 7+8=15 / 4+5+6=15 / 1+2+3+4+5=15 와 같이 총 3가지의 경우가 존재한다

// lt가 rt를 따라가는 구조.
// rt를 for문 안에서 사용.
// for문으로 rt값을 sum에 더하고 while문에서 lt값을 sum에서 뺀다. -> 더하고나서 비교확인, 빼고나서 비교확인 (2번 체크)

public class Algorithm_03_05 {
    static void Solution(int n, int[] nArr){

        // 예시 입력 : 15
        // 예시 출력 : 3
        int lt = 0, sum = 0, result = 0;
        for (int rt = 0; rt < n-1; rt++) { // 연속된 자연수의 합으로만 n값을 구해야 하니 미자막 n값은 제외
            sum += nArr[rt];
            if(sum == n) result ++;
            while(sum >= n){
                sum -= nArr[lt++];
                if(sum == n) result ++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = i+1;
        }
        Solution(n, nArr);

    }
}
