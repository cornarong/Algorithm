package algorithm01;

import java.util.Scanner;

// ## 암호 ## (replace(),parseInt(String,2)
// ** Point
// Integer.parsInt(int형으로 변환할 String, 첫번째 매게변수의 값을 몇 진수로 인식할 것인지)
// 아스키코드를 String으로 변환 방법 -> 받을String변수 = (char)아스키코드번호
public class Algorithm_01_12 {

    static void Solution(int num, String str){

        String result = "";
        for (int i = 0; i < num; i++) {
            String temp = str.substring(0,7).replace("#","1").replace("*","0");
            int temp2 = Integer.parseInt(temp,2); //
            result += (char)temp2;
            str = str.substring(7);
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();
        Solution(num,str);

    }
}
