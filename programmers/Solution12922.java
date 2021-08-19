package programmers;

// ## [연습문제] 수박수박수박수박수박수? ##
// https://programmers.co.kr/learn/courses/30/lessons/12922

public class Solution12922 {
    public String solution(int n) {
        String answer = "";
        for (int i = 1; i <= n; i++) {
            if(i==1 || i%2!=0){
                answer += "수";
            }else{
                answer += "박";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution12922 s = new Solution12922();
        // 예시 입력 1번, return = "수박수"
        int n = 3;
        // 예시 입력 2번, return = "수박수박"
//        int n = 4;
        s.solution(n);

    }
}
