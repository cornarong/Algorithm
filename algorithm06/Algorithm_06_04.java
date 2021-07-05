package algorithm06;

import java.util.Scanner;

// ## Least Recently Used ##
// LRU(캐시, 카카오 변형)

public class Algorithm_06_04 {

    static void Solution(int s, int n, int[] arr){

        int[] cache = new int[s];
        int check = 0;
        for(int x : arr){
            // 현재 캐쉬에 같은 숫자 확인 후 -> 있을 경우 인덱스 번호를 check에 저장.
            for (int j = 0; j < cache.length; j++) {
                if(cache[j] == x) {
                    check = j;
                    break;
                }
            }
            // 현재 캐쉬에 같은 숫자가 없다. // s는 length니까 -2 ( * 실제 인덱스는 length-1)
            if(check == 0){
                for (int j = s-2; j >=0; j--) {
                    cache[j+1] = cache[j];
                }
                cache[0] = x;
            // 현재 캐쉬에 같은 숫자가 있다. // check는 실제 인덱스값이니까 -1
            } else {
                for (int j = check-1; j >=0; j--) {
                    cache[j+1] = cache[j];
                }
                cache[0] = x;
            }
        check = 0;
        }

        for(int x : cache) System.out.printf(x+" ");

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution(s, n, arr);

    }
}
