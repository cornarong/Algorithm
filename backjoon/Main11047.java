package backjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// ## 동전 0 (그리디 알고리즘) ##
// https://www.acmicpc.net/problem/11047

public class Main11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] aArr = new Integer[n];
        for(int i = 0; i < aArr.length; i++){
            aArr[i] = sc.nextInt();
        }

        Arrays.sort(aArr, Collections.reverseOrder());

        int cnt = 0;
        while(true) {
            for(int i = 0; i < n; i ++){
                if(aArr[i] > k) continue;
                if(k % aArr[i] == 0){
                    cnt = cnt + (k / aArr[i]);
                    k = 0;
                    break;
                }else{
                    k = k - aArr[i];
                    cnt++;
                    break;
                }
            }
            if(k <= 0) break;
        }
        System.out.println(cnt);
    }
}
