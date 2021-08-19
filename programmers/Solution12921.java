package programmers;

// ## [연습문제] 소수 찾기 ##
// https://programmers.co.kr/learn/courses/30/lessons/12921

public class Solution12921 {
    // 가장 효율적. 시간 복잡도 : O(√N) * for문 조건 외워버리자.
    private boolean isPrime(int num){
        for (int i = 2; i*i <= num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) answer++;
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Solution12921 s = new Solution12921();
//        int n = 10; // result = 4
        int n = 5; // result = 3
        s.solution(n);
    }
}
