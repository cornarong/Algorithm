import java.util.Scanner;

// ## 피보나치 수열 ##
// 아래 방식은 배열을 사용하지 않은 방식.
// 배열을 사용시 매우 쉬움.
// 앞의 1,1은 고정.
public class Algorithm_02_04 {

    static void Solution(int num){

        int cnt1 = 1, cnt2 = 1, cnt3 = 0;
        String result = "1 1 ";
        for (int i = 2; i < num; i++) {
            cnt3 = cnt1+cnt2;
            result += cnt3+" ";
            cnt1 = cnt2;
            cnt2 = cnt3;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Solution(num);

    }
}

