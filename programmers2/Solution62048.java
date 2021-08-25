package programmers2;

// ## [Summer/Winter Coding(2019)] 멀쩡한 사각형 ##
// https://programmers.co.kr/learn/courses/30/lessons/62048
// https://cornarong.tistory.com/55 - 개인 블로그 정리

public class Solution62048 {
    private long Yaksu(long a, long b){ // 최대 공약수 구하는 함수
        long min = Math.min(a, b);
        long max = 0;
        for (long i = 1; i <= min; i++) {
            if(a % i == 0 && b % i == 0) max = Math.max(max,i);
        }
        return max;
    }
    public long solution(long w, long h) {
        long answer = 1;
        long maxYaksu = Yaksu(w, h);
        answer = w * h - (w + h - maxYaksu);
//        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Solution62048 s = new Solution62048();
        // 예시 입력 / 출력 result = 80
        // W, H : 1억 이하의 자연수
        long w = 8;
        long h = 12;
        s.solution(w, h);
    }
}
