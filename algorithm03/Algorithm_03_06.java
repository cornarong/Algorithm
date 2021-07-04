package algorithm03;

import java.util.Scanner;

// ## 최대 길이 연속부분수열 ##
// rt값은 1씩 증가하면서. lt가 따라오는 구조.
// * point : rt-lt+1 -> lt부터 rt까지의 길이(sum)

public class Algorithm_03_06 {

    static void Solution(int n, int k, int[] nArr){

        int lt = 0, result = 0, cnt = 0;
        for (int rt = 0; rt < n; rt++) {
            if(nArr[rt] == 0) cnt++;
            while (cnt > k){
                if(nArr[lt] == 0) cnt--;
                lt++;
            }
            result = Math.max(result,(rt-lt)+1); // 기존 사용하던 sum += nArr[rt] 같은 역할 (누적,비교 역할)
        }
        System.out.println(result);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        Solution(n, k, nArr);



    }
}
