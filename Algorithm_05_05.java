import java.util.Scanner;
import java.util.Stack;

// ## 쇠막대기 ##
// 로직 구상하기가 힘들었음..
// 1. x == '('는 무조건 stack에 push한다. -> '(' 갯수로 카운터를 셀것임.
// 2. x == ')'는 무조건 stack에 push하지 않음. -> ')'값을 만날 때마다 처리해 줄 것임.

public class Algorithm_05_05 {

    static void Solution(String str){

        Stack<Character> stack = new Stack<>();
        int result = 0;
        char temp = ' ';
        for (char x : str.toCharArray()){
            if(x == '(') stack.push(x);
            else{
                if(temp == '(') {
                    stack.pop();
                    result += stack.size();
                }else{
                    stack.pop();
                    result++;
                }
            }
            temp = x;
        }
        System.out.println(result);

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution(str);

    }
}
