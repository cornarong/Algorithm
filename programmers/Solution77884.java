package programmers;

import java.util.HashMap;

// ## [월간 코드 챌린지 시즌2] 약수의 개수와 덧셈 ##
// https://programmers.co.kr/learn/courses/30/lessons/77884

public class Solution77884 {
    public int solution(int left, int right) {
        int answer = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = left; i <= right; i++) {
            for (int j = 1; j <= i ; j++) {
                if(i % j == 0) hash.put(i, hash.getOrDefault(i,0)+1);
            }
        }
        for(int x : hash.keySet()) {
            if(hash.get(x) % 2 == 0){
                answer += x;
            }else{
                answer -= x;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        // 예시 입력 result = 43
        int left = 13;
        int right = 17;
        Solution77884 s = new Solution77884();
        s.solution(left, right);
    }
}
