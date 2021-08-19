package programmers;

import java.util.Arrays;
import java.util.Collections;

// ## [연습문제] 문자열 내림차순으로 배치하기 ##
// https://programmers.co.kr/learn/courses/30/lessons/12917

// * StringBuilder의 reverse() 메소드를 이용해도 된다.

public class Solution12917 {
    public String solution(String s) {
        String answer = "";
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i);
        Arrays.sort(arr, Collections.reverseOrder());
        for(char x : arr) answer += x;
        return answer;
    }
    public static void main(String[] args) {
        Solution12917 T = new Solution12917();
        // 예시 입력 1번, return = "gfedcbZ"
        String s = "Zbcdefg";
        T.solution(s);
    }
}
