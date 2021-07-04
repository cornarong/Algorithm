package Algorithm01;

import java.util.Scanner;

// ## 특정 문자 뒤집기 ##
// String str을 char배열로 받기 ==> str.toCharArray();
// char배열을 String로 받기 ==> String.valueOf(char배열)
// isLetterOrDigit : 특스문자 포함여부 확인 / 특수문자 없을 경우 true , 있을 경우 false
// *point : lr:char배열의 첫번째 인덱스 , rt:char배열의 마지막값 인덱스 사용
public class Algorithm_01_05_N {

    public String Solution(String str){
        char[] chaArray = str.toCharArray();
        int lt = 0;
        int rt = str.length()-1;

        while(lt < rt){
            char temp = chaArray[lt];
            if(Character.isLetterOrDigit(temp) == true &&
                    Character.isLetterOrDigit(chaArray[rt]) == true) {
                chaArray[lt] = chaArray[rt];
                chaArray[rt] = temp;
            }
            lt ++;
            rt --;
        }
        return String.valueOf(chaArray);
    }
    public static void main(String[] args) {
        Algorithm_01_05_N t = new Algorithm_01_05_N();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(t.Solution(str));
    }
}
