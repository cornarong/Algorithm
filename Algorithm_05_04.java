import java.util.Scanner;
import java.util.Stack;

// ## 후위식 연산 (postifx) ##

// * point1 : char형 숫자는 아스키 코드로 호출된다. ex) char x=0 -> char x=48
// 따라서 해당 숫자로 그대로 받기 위해서는 아래 2가지 방식이 존재한다.
// -> 1.  x값 - 48
// -> 2. Character.getNumericValue(x값)

// * point2 : 문자 또는 특수문자 인지 판단하는 방법.
// Character.isDigit(x값) -> return : true / false (char 값이 숫자인지 여부를 판단하는 함수)

public class Algorithm_05_04 {

    static void Solution(String str){

        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) stack.push(x-48);
            else{
                int a = stack.pop();
                int b = stack.pop();
                if(x=='+') stack.push(b+a);
                else if(x=='-') stack.push(b-a);
                else if(x=='/') stack.push(b/a);
                else if(x=='*') stack.push(b*a);
            }
        }
        System.out.println(stack.peek());


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution(str);


    }
}
