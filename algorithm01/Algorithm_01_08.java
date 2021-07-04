package algorithm01;

import java.util.Scanner;

// ## 유효한 팰린드롬 ##
public class Algorithm_01_08 {

    static void Solution(String str){

        char[] chaArray = str.toCharArray();
        for(int i=0;i<chaArray.length;i++){
            if(!Character.isAlphabetic(chaArray[i])) chaArray[i] = ' ';
        }
        str = String.valueOf(chaArray).toString().toUpperCase().replaceAll(" ","");
        StringBuffer sb = new StringBuffer(str);
        String reverseStr = sb.reverse().toString();

        if(str.equals(reverseStr)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution(str);
    }
}
