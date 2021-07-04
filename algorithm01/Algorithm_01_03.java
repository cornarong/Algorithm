package algorithm01;

import java.util.Scanner;

// ## 문장 속 단어 ##
// sc.next(); -> next는 토큰 형식으로 공백을 구분자로 인식하여 구분자는 저장하지 않음.
// Scanner 공백 받을 때 sc.nextLine();
public class Algorithm_01_03 {

    static void Solution(String str){
        String[] strArray = str.split("\\s");
        String result = strArray[0];
        for (int i = 0; i < strArray.length; i++) {
            if(result.length() < strArray[i].length()) result = strArray[i];
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution(str);

    }
}
