package test;

import java.util.Scanner;

// ## 연속부분수열(복합적문제) ##
// O(n2) -> O(n)으로 해결해야 함.
// * lt가 rt를 따라가는 구조
// sum이 m보다 작으면 rt++;
// sum이 m보다 크면 lt--;


public class Algorithm_03_04 {

    static void Solution(int n,int m,int[] valArr) {

        // 입력 예시
        // 8 6
        // 1 2 1 3 1 1 1 2

        int lt = 0, sum = 0, result = 0;
        for (int rt = 0; rt < n; rt++) { // rt를 for문의 조건으로 사용
            sum += valArr[rt]; // 한값씩 sum에 더한다. -> sum이 m을 초과할 경우 밑의 while에서 처리.
            if(sum == m) result++;
            while(sum >= m){ // sum이 m보다 크거나 같은경우 lt++로 rt를 1칸 따라간다. -> 이미 같은 값은 누적되었음.
                sum -= valArr[lt++]; // 따라간 lt값을 sum에서 빼준다.
                if(sum == m) result++; // lt값이 rt값을 따라가면서 sum에서 lt값을 지우다가 sum과 m이 같은 경우 발생.
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] valArr = new int[n];
        for (int i = 0; i < n; i++) {
            valArr[i] = sc.nextInt();
        }
        Solution(n,m,valArr);

    }

}
