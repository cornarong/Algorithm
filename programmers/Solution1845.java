package programmers;

import java.util.HashSet;

// ## 폰켓못 ##
// https://programmers.co.kr/learn/courses/30/lessons/1845

public class Solution1845 {
    static int[] nums = {3,3,3,2,2,4}; // 가

    public int solution(int[] nums) {
        // getMax = 가질 수 있는 최대 폰켓몬 수를 구한다.
        // 폰켓몬들의 중복을 제거한다.
        int answer = 0, getMax = nums.length/2;
        HashSet<Integer> getTemp = new HashSet<>();
        for(int x : nums) getTemp.add(x);

        if(getTemp.size() > getMax) answer = getMax;
        else answer = getTemp.size();

        return answer;
    }

    public static void main(String[] args) {
        Solution1845 main = new Solution1845();
        main.solution(nums);

    }
}
