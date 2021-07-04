package Algorithm05;

import java.util.Scanner;
import java.util.Stack;

// ##  올바른 괄호 (Stack) ##

// * Stack의 지원 메서드.
// push : 데이터 추가
// peek : 가장 추가된(Top) 데이터 조회
// pop : 최근에 추가된(Top) 데이터 삭제
// IsEmpty : stack의 값이 비었는지 확인 여부 , boolean Type
// seach : 인자값으로 받은 데이터의 위치를 반환 , int Type

public class Algorithm_05_01 {

    static void Solution(String str){

        Stack<Character> stack = new Stack<>();
        char[] strArr = str.toCharArray();
        String result = "NO";

        for(char x : strArr){
            if(!stack.isEmpty() && stack.peek() == '(' && x == ')') {
                stack.pop();
            } else {
                stack.push(x);
            }
        }

        if(stack.isEmpty()) result = "YES";

        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution(str);

    }
}
