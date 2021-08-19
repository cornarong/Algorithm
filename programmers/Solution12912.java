package programmers;

// ## [연습문제] 두 정수 사이의 합 ##
// https://programmers.co.kr/learn/courses/30/lessons/12912

public class Solution12912 {
    public long solution(int a, int b) {
        long answer = 0;
        if(b < a) {
            int temp = b;
            b = a;
            a = temp;
        }
        for (int i = a; i <= b; i++) answer += i;
        return answer;
    }
    public static void main(String[] args) {
        Solution12912 s = new Solution12912();
        // 예시 입력 1번 , return = 12
//        int a = 3;
//        int b = 5;
        // 예시 입력 2번 , return = 3
//        int a = 3;
//        int b = 3;
        // 예시 입력 3번 , return = 12
        int a = 5;
        int b = 3;
        s.solution(a, b);
    }
}
