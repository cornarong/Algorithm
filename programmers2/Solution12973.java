package programmers2;

import java.util.Stack;

// ## [2017 팁스타운] 짝지어 제거하기 ##
// https://programmers.co.kr/learn/courses/30/lessons/12973
// String s와 stack의 요소들과 *비교를 하면서 처리한다.

public class Solution12973 {
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c) { // peek으로 stack의 값과 현재 c값을 비교.
                stack.pop(); // 같으면 stack의 값을 값 제거.
            }else {
                stack.push(c); // 스택 비어 있으면 값 넣어준다.
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}