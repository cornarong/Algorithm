package Algorithm01;

import java.util.Scanner;

// ## 숫자만 추출 ##
public class Algorithm_01_09 {

    static void Solution(String str){

        str = str.replaceAll("[A-z]"," ").replaceAll(" ","");
        if(str.length()<9) {
            System.out.println(Integer.parseInt(str));
        }else{
            System.out.println(0);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution(str);

    }
}
