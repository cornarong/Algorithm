package programmers2;

import java.util.Arrays;
import java.util.Comparator;


// ## [정렬] 가장 큰 수 ##
// https://programmers.co.kr/learn/courses/30/lessons/42746
// https://cornarong.tistory.com/59 - 개인 블로그 정리
// 기존 입력받은 int배열을 String배열로 변환하여 Comparator를 이용하여 s1과 s2을 각각 순서로 더해서 정렬해준다.
// ex) 3, 32 => 332 or 323 => 내림차순 정렬

public class Solution42746 {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] strArr = new String[len];
        for(int i=0; i<len; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });

        if(strArr[0].equals("0")) answer = "0"; // 0요소 배열 처리.
        else{
            StringBuilder sb = new StringBuilder();
            for(String x : strArr) {
                sb.append(x);
            }
            answer = sb.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution42746 s = new Solution42746();
        int[] numbers = {3, 30, 34, 5, 9};
        s.solution(numbers);
    }
}
