package programmers;

// ## [연습문제] 문자열 다루기 기본 ##
// https://programmers.co.kr/learn/courses/30/lessons/12918

public class Solution12918 {
    public boolean solution(String s) {
        // length 4 or 6 , only number
        if(s.length() == 4 || s.length() == 6){
            for (int i = 0; i < s.length(); i++) {
                if(!Character.isDigit(s.charAt(i))){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution12918 T = new Solution12918();

        // 예시 입력 1번, return = false
        String s = "a234";

        // 예시 입력 2번, return = true
//        String s = "1234";

        T.solution(s);
    }
}
