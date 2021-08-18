package programmers;

// ## [연습문제] 가운데 글자 가져오기 ##
// https://programmers.co.kr/learn/courses/30/lessons/12903

public class Solution12903 {
    public String solution(String s) {
        String answer = "";
        int index = s.length()/2;
        if(s.length()%2 == 0){
            answer += s.charAt(index-1);
            answer += s.charAt(index);
        }else{
            answer += s.charAt(index);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution12903 T = new Solution12903();
        // 예시 입력1번 ,return = "c"
        String s = "abcde";
        // 예시 입력2번 ,return = "we"
//        String s = "qwer";
        T.solution(s);
    }
}
