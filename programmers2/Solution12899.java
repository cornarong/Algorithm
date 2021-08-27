package programmers2;

// ## [연습문제] 124 나라의 숫자 ##
// https://programmers.co.kr/learn/courses/30/lessons/12899

public class Solution12899 {

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n >= 3){
            int a = n/3;
            int b = n%3;
            if(b == 0) {
                a = a-1;
                sb.append(4);
            }
            else sb.append(b);
            n = a;
        }
        if(n != 0) sb.append(n);
        String answer = sb.reverse().toString();
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Solution12899 s = new Solution12899();
        // 입출력 예
//        int n = 1; // result = 1
//        int n = 2; // result = 2
//        int n = 3; // result = 4
        int n = 4; // result = 11
        s.solution(n);
    }
}
