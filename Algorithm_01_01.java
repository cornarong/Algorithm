import java.util.Scanner;

// ## 문자 찾기 ##
// char은 대소문자 변환 시 Character.toUpperCase(인자값) 이런식으로 사용해야함.
// String 문자열을 char[]에 한글자씩 담는 방법 => char[] 변수명 = 문자열.toCharArray();
public class Algorithm_01_01 {


    static void Solution(String str,char cha){
        str = str.toUpperCase();
        cha = Character.toUpperCase(cha);
        int count = 0;
        char[] chaArray = str.toCharArray();
        for (char check : chaArray) {
            if(cha == check) count++;
        };
        System.out.println(count);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char cha = sc.next().charAt(0);
        Solution(str,cha);

    }
}
