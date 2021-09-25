package baekjoon;

import java.util.Scanner;

// ## 분해합 (브루트포스 알고리즘) ##
// https://www.acmicpc.net/problem/2231

public class Main2231 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int len = n.length();
        int max = 0;
        for(int i=0; i<len; i++){
            max += 9;
        }

        int result = Integer.MAX_VALUE;
        int st = Integer.parseInt(n) - max;
        if(st < 0) st = 0;
        int ed = Integer.parseInt(n);
        for (int i = st; i < ed; i++) {
            int sum = 0;
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                sum += Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
            if(ed == i+sum){
                result = Math.min(result, i);
                break;
            }
        }
        if(result == Integer.MAX_VALUE) result = 0;
        System.out.println(result);
    }
}
