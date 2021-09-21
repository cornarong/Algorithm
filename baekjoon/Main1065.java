package baekjoon;

import java.util.Scanner;

// ## 한수 (브루트포스 알고리즘) ##
// https://www.acmicpc.net/problem/1065
// ** point : 99까지의 두 자리 수는 등차수열인지를 판단할 다른 자리 수가 없기 때문에 모두 한수가 성립하게 된다.


public class Main1065 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if(i <= 99){
                result++;
            }else{
                int check = 0;
                String temp = String.valueOf(i);
                int rest = temp.charAt(1) - temp.charAt(0);
                for (int j = 1; j < temp.length()-1; j++) {
                     if (rest != temp.charAt(j+1) - temp.charAt(j)){
                         check = 1;
                         break;
                     }
                }
                if(check == 0) result++;
            }
        }
        System.out.println(result);
    }
}
