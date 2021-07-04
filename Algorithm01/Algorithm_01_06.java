package Algorithm01;

import java.util.Scanner;

//  ## 중복문자제거 ##
//  for문으로 해당 값의 인덱스를 비교한다.
//  indexOf(값)-> 첫번째로 나오는 값의 인덱스
//  소스로 보는게 편함. 정리하면
//  if(for의 i값이 str의 첫번째로 나오는 값의 인덱스번호랑 같으냐) 같으면 중복아니다.
public class Algorithm_01_06 {

    static void Solution(String str) {
        String temp = "";
        for(int i=0;i<str.length();i++){
            if(i == str.indexOf(str.charAt(i))){
                temp += str.charAt(i);
            }
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution(str);
    }
}
