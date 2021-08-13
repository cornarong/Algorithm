package programmers;

import java.util.Arrays;

// ##[Summer/Winter Coding(~2018)] 예산 ##
// https://programmers.co.kr/learn/courses/30/lessons/12982?language=java
public class Solution12982 {

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            if(budget == 0 || budget < d[i]) break;
            budget -= d[i];
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
//        int[] d = {2,2,3,3};
        int budget = 9;
//        int budget = 10;
        Solution12982 s = new Solution12982();
        s.solution(d, budget);
    }
}
