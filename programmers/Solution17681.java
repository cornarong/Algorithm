package programmers;

// ## 2018 KAKAO BLIND RECRUITMENT [1차] 비밀지도 ##
// https://programmers.co.kr/learn/courses/30/lessons/17681

public class Solution17681 {
    // 다른 풀이
    // String.format("%" + n + "s", 문자열); -> %n자리수 만큼 문자열 s의 길이를 체크하여 n보다 작을 경우 0으로 채운다.

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int zero1 = n - Integer.toBinaryString(arr1[i]).length();
            int zero2 = n - Integer.toBinaryString(arr2[i]).length();
            String temp1 = "", temp2 = "";
            for (int j = 0; j < zero1; j++) temp1 += "0";
            for (int j = 0; j < zero2; j++) temp2 += "0";
            // 이진수 확인.
//            System.out.println(arr1[i]+" = "+temp1+Integer.toBinaryString(arr1[i]));
//            System.out.println(arr2[i]+" = "+temp2+Integer.toBinaryString(arr2[i]));
            temp1 = temp1+Integer.toBinaryString(arr1[i]);
            temp2 = temp2+Integer.toBinaryString(arr2[i]);
            String result = "";
            for (int j = 0; j < n; j++) {
               if(temp1.charAt(j) == '1' || temp2.charAt(j) == '1'){
                   result += "#";
               }else{
                   result += " ";
               }
            }
            answer[i] = result;
        }
        // 최종 확인.
//        for(String x : answer) System.out.println(x);
        return answer;
    }

    public static void main(String[] args) {
        // 입출력 예제 1번
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        // 입출력 예제 2번
//        int n = 6;
//        int[] arr1 = {46, 33, 33 ,22, 31, 50};
//        int[] arr2 = {27, 56, 19, 14, 14, 10};
        Solution17681 s = new Solution17681();
        s.solution(n, arr1, arr2);
    }
}
