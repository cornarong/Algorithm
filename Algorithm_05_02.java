import java.util.Scanner;
import java.util.Stack;

// ## 괄호문자제거 ##
// Stack 사용
// -> 초기값 check = 0을 기준으로 들어오는 데이터가 '(' 이면 check++;, ')' 이면 check--;
// -> check != 0이 아닐 경우 괄호가 닫히지 않은 상태로 확인 데이터 push하지 않고 넘어간다.
// -> check == 0일 경우 괄호가 전부 닫힌 상태로 확인 하고 후에 들어오는 데이터는 push한다.
// * point : 로직 순서 -> 1.check++; 2.check비교 후 psuh 3.check--;

public class Algorithm_05_02 {

    static void Solution(String str){

        Stack<Character> stack = new Stack<>();
        int check = 0;
        for(char x : str.toCharArray()){
            if(x == '(') check++;
            if(check == 0) stack.push(x);
            if(x == ')') check--;
        }
        String result = "";
        for(char x : stack) {
            result += x;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution(str);

    }
}
