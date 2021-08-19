package programmers;

import java.util.ArrayList;
import java.util.Collections;

// ## [연습문제] 나누어 떨어지는 숫자 배열 ##
// https://programmers.co.kr/learn/courses/30/lessons/12910

public class Solution12910 {

    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) arrList.add(arr[i]);
        }
        if(arrList.size()==0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            Collections.sort(arrList);
            answer = new int[arrList.size()];
            for (int i = 0; i < arrList.size(); i++) {
                answer[i] = arrList.get(i);
            }
        }
//        for(int x: answer) System.out.println(x);
        return answer;
    }
    public static void main(String[] args) {
        // 예시 입력 1번, return = {5, 10}
//        int[] arr = {5, 9, 7, 10};
//        int divisor = 5;
        // 예시 입력 2번, return = {1, 2, 3, 36}
//        int[] arr = {2, 36, 1, 3};
//        int divisor = 1;
        // 예시 입력 3번, return = {-1}
        int[] arr = {3, 2, 6};
        int divisor = 10;
        Solution12910 s = new Solution12910();
        s.solution(arr , divisor);

    }
}
