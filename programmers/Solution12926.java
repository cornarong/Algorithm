package programmers;

// ## [연습문제] 시저 암호 ##
// https://programmers.co.kr/learn/courses/30/lessons/12926

public class Solution12926 {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if(Character.isAlphabetic(sArr[i])){
                int temp = sArr[i]+n;
                if(sArr[i] <= 90) {
                    if(temp-90 > 0){
                        sb.append(Character.toString(64+(temp-90)));
                    }else{
                        sb.append(Character.toString(temp));
                    }
                }else{
                    if(temp-122 > 0){
                        sb.append(Character.toString(96+(temp-122)));
                    }else{
                        sb.append(Character.toString(temp));
                    }
                }
            }else sb.append(sArr[i]);
        }
        answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) {
        Solution12926 T = new Solution12926();
        // 예시 입력 1번, result = "BC"
//        String s = "AB";
//        int n = 1;
        // 예시 입력 2번, result = "a"
        String s = "z";
        int n = 1;
        // 예시 입력 3번, result = "e F d"
//        String s = "a B z";
//        int n = 4;
//        T.solution(s, n);
    }
}
