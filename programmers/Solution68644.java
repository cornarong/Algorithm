package programmers;

import java.util.TreeSet;

// ## [월간 코드 챌린지 시즌1] 두 개 뽑아서 더하기 ##
// https://programmers.co.kr/learn/courses/30/lessons/68644

public class Solution68644 {

    public int[] solution(int[] numbers) {
        TreeSet<Integer> arr = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) arr.add(numbers[i]+numbers[j]);
        }
        int[] answer = new int[arr.size()];
        int index = 0;
        for(int x : arr){
            answer[index] = x;
            index++;
        }
        // * HashSet 대신 TreeSet 사용시 add 하면서 정렬도 같이 된다.
        // Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        // 예시 1번 / return = {2,3,4,5,6,7}
//        int[] numbers = {2,1,3,4,1};
        int[] numbers = {1,3,5,7,9};
        // 예시 2번 / return = {2,5,7,9,12}
//        int[] numbers = {5,0,2,7};
        Solution68644 s = new Solution68644();
        s.solution(numbers);

    }
}
