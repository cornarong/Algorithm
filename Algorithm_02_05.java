import java.util.Scanner;

// ## 소수(에라토스테네스 체) ##
public class Algorithm_02_05 {

    static void Solution(int num){

        int[] primeNumber = new int[num+1];
        for (int i=0; i<num+1; i++){
            primeNumber[i] = i;
        }
        for (int i = 2; i < num+1; i++) {
            if(primeNumber[i] != 0) {
                for (int j = 2*i; j < num+1; j+=i) {
                    primeNumber[j] = 0;
                }
            }
        }
        int result = 0;
        for (int i = 2; i < num+1; i++){
            if (primeNumber[i] != 0) {
                result++;
            }
        }
        System.out.println(result);

        // 1.배열을 생성하여 초기화한다.
        // 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.(지울 때 자기자신은 지우지 않고, 이미 지워진 수는 건너뛴다.)
        // 3. 2부터 시작하여 남아있는 수를 모두 출력한다.
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Solution(num);
    }
}