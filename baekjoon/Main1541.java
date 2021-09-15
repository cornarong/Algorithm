package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// ## 잃어버린 괄호 (수학, 문자열, 그리디 알고리즘, 파싱) ##
// https://www.acmicpc.net/problem/1541
// point - 수학적 구현

public class Main1541 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] arr = s.split("-");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].contains("+")){
                int temp = 0;
                String[] sTemp = arr[i].split("\\+");
                for (String x : sTemp){
                    if(!x.equals("+")) temp += Integer.parseInt(x);
                }
                list.add(temp);
            }else{
                list.add(Integer.parseInt(arr[i]));
            }
        }
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }
        System.out.println(result);
    }
}
