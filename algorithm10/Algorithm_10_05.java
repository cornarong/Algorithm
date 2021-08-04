package algorithm10;

import java.util.Arrays;
import java.util.Scanner;

// ## 동전교환(냅색 알고리즘) ##
public class Algorithm_10_05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        // 중복가능 -> 오름차순
        // 동전 수를 구해야한다.

        int[] dy = new int[m+1]; // 거스름돈 1~m 까지의 배열
        Arrays.fill(dy,Integer.MAX_VALUE); // 최소값을 구해야 하니 우선 최대값으로 정렬
        dy[0] = 0; // * 필수 체크
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j-coins[i]]+1); // coins[i]를 사용해 보았으니 +1(갯수) 해준다.
            }
        }
        System.out.println(dy[m]);
    }
}
