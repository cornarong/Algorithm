import java.util.Scanner;

// ## 대소문자 변환 ##
// 대소문자 체크 함수 Character.isUpperCase/isLowerCase(해당char) or ;
public class Algorithm_01_02 {

    static void Solution(String str){
        String result = "";
        for(int i=0;i<str.length();i++){
          if(Character.isUpperCase(str.charAt(i)) == true){
              result += str.toLowerCase().charAt(i);
          }else{
              result += str.toUpperCase().charAt(i);
          }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution(str);

    }

}
