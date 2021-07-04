package algorithm02;

import java.util.Scanner;

// 뒤집은 소수
// 1. 입력받은 정수 배열에 담기 -> for문으로 값 뒤집어 배열에 담기
// 2. 뒤집은 소수를 인덱스별로 checkPrimeNum 함수에 값을 하나씩 넘겨 true,false로 구분 true면 출력
public class Algorithm_02_06 {

    public static Boolean checkPrimeNum(int primeNum){

                      
        if(primeNum == 1) return false;
        for (int i = 2; i < primeNum; i++) {
             if(primeNum % i == 0){
                 return false;
            }
        }
        return true;
    }

    static void Solution(int num, int[] primeNum){

        for (int i = 0; i < num; i++) {

            int temp = primeNum[i];
            int result = 0;
            while(temp > 0){
                int res = temp % 10;
                result = result * 10 + res;
                temp = temp / 10;
            }
            primeNum[i] = result;
        }

        for (int i = 0; i < num; i++) {
            if(checkPrimeNum(primeNum[i]) == true){
                System.out.printf(primeNum[i]+" ");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] primeNum = new int[num];
        for (int i = 0; i < num; i++) {
            primeNum[i] = sc.nextInt();
        }
        Solution(num,primeNum);


    }
}
