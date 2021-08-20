package programmers;

// ## [연습문제] 서울에서 김서방 찾기 ##
// https://programmers.co.kr/learn/courses/30/lessons/12919

public class Solution12919 {
    public String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) return "김서방은 "+i+"에 있다";
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution12919 s = new Solution12919();
        // 예시 입력 1번 , return = "김서방은 1에 있다"
        String[] seoul = {"Jane", "Kim"};
        s.solution(seoul);
    }
}
