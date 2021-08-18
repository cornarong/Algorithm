package programmers;

import java.util.ArrayList;

// ## [연습문제] 같은 숫자는 싫어 ##
// https://programmers.co.kr/learn/courses/30/lessons/12906

public class Solution12906 {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            if(temp != arr[i]) {
                list.add(arr[i]);
                temp = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
//        for(int x : answer) System.out.println(x);
        return answer;
    }
    public static void main(String[] args) {
        Solution12906 s = new Solution12906();
        // 예시 입출력 1번
        int[] arr = {1,1,3,3,0,1,1}; // answer = {1,3,0,1}
        // 예시 입출력 2번
//        int[] arr = {4,4,4,3,3};  // answer = {4,3}
        s.solution(arr);
    }
}
