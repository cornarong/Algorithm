package programmers;

// ## [월간 코드 챌린지 시즌1] 내적 ##
// https://programmers.co.kr/learn/courses/30/lessons/70128
public class Solution70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
    public static void main(String[] args){
        Solution70128 s = new Solution70128();
        // 예시 1번 result = 3
//        int[] a = {1,2,3,4};
//        int[] b = {-3,-1,0,2};
        // 예시 2번 result = -2
        int[] a = {-1,0,1};
        int[] b = {1,0,-1};
        s.solution(a, b);
    }
}
