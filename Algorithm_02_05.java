import java.util.Scanner;

public class Algorithm_02_05 {

// ## 소수(에라토스테네스 체) ##
    static void Solution(int num){

        // 인덱스번호로 작업을 진행하기 위해 -> 들어온 Int값 만큼 인덱스번호를 생성 -> num+1
        int[] primeNumber = new int[num+1];

        int count = 0;
        for (int i = 2; i < num; i++) {
            if(primeNumber[i] == 0){
                count++;
                for (int j=2*i ; j < num; j+=i) {
                    primeNumber[j] = 1;
                }
            }
        }
        System.out.println(count);

        // 1.배열을 생성하여 초기화한다.
        //  -> 동적배열 초기화 시 배열만큼 값 "0"이 할당된다.
        //  -> 2부터 시작하여 해당 값이 0인경우 count++;
        //  -> 위 조건문 안에서 반복문으로 특정 수의 배수의 값을 1로 변경
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Solution(num);


    }
}