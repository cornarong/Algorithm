package programmers;

import java.util.Locale;

// ## [연습문제] 문자열 내 p와 y의 개수 ##
// https://programmers.co.kr/learn/courses/30/lessons/12916

public class Solution12916 {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0, yCnt = 0;
        s = s.toUpperCase(Locale.ROOT);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P') pCnt++;
            if(arr[i] == 'Y') yCnt++;
        }
        if(pCnt != yCnt) answer = false;
        return answer;
    }
    public static void main(String[] args) {
        // 예시 입력 1번, answer = true
        String s = "pPoooyY";
        // 예시 입력 2번, answer = false
//        String s = "Pyy";
        Solution12916 T = new Solution12916();
        T.solution(s);
    }
}
