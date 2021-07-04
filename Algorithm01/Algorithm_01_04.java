package Algorithm01;

import java.util.ArrayList;
import java.util.Scanner;

// ## 단어 뒤집기 ##
public class Algorithm_01_04 {

    static void Solution(ArrayList<String> strList){

        ArrayList<String> resultList = new ArrayList<>();

        for (String str : strList){
            String newStr = "";
            for (int i=str.length(); i >= 1; i--){
                newStr += Character.toString(str.charAt(i-1));
            }
            resultList.add(newStr);
        }
        for (String result : resultList){
            System.out.println(result);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strList = new ArrayList<>();
        
        int num = sc.nextInt();
        sc.nextLine(); // sc.nextInt()는 마지막 입력값 엔터(개행)을 제거하지 않아서 처리.

        for (int i=0; i<num; i++) {
            strList.add(sc.next());
        }
        Solution(strList);
    }
}
