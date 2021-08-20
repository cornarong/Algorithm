package programmers;

// ## [연습문제] 약수의 합 ##
// https://programmers.co.kr/learn/courses/30/lessons/12928

public class Solution12928 {
    public int solution(int n) {
        // n의 약수를 모두 더한 값
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(n%i==0) answer += i;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution12928 s = new Solution12928();
        // 예시 입력 1번, return = 28
//        int n = 12;
        // 예시 입력 2번, return = 6
        int n = 5;
        s.solution(n);
    }

}
