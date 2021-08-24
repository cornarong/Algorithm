package programmers2;

// ## [2020 KAKAO BLIND RECRUITMENT] 문자열 압축 ##
// https://programmers.co.kr/learn/courses/30/lessons/60057

public class Solution60057 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length()==1) answer = 1; // 최소길이 1개 처리
        for (int i = 1; i <= s.length()/2; i++) {
            String result = "", now = "", next = ""; // 누적값, 현재값, 다음값
            int cnt = 1;
            for (int j = 0; j < s.length(); j=j+i) {
                if(j+i+i > s.length()){
                    if(cnt>1) {
                        result += cnt+""+next;
                        if(j+i < s.length()) result += s.substring(j+i);
                        break;
                    }else {
                        result += s.substring(j);
                        break;
                    }
                }else{
                    now = s.substring(j,j+i);
                    next = s.substring(j+i,j+i+i);
                    if(now.equals(next)){
                        cnt++;
                    }else{
                        if(cnt>1) {
                            result += cnt+""+now;
                            cnt = 1;
                        }else result += now;
                    }
                }
            }
//        System.out.println(i+"개 단위 압축 = " + result);
            answer = Math.min(answer,result.length());
        }
//        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Solution60057 T = new Solution60057();
//        String s = "aabbaccc"; // 7
//        String s = "ababcdcdababcdcd"; //9
//        String s = "abcabcdede"; //8
//        String s = "abcabcabcabcdededededede"; //14
//        String s = "xababcdcdababcdcd"; //17
        String s = "a"; // 1
        T.solution(s);
    }
}
