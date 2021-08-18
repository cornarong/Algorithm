package programmers;

import java.util.ArrayList;
import java.util.Collections;

// ## [연습문제] 문자열 내 마음대로 정렬하기 ##
// https://programmers.co.kr/learn/courses/30/lessons/12915

public class Solution12915 {
    static class ST implements Comparable<ST>{
        String st;
        int n;
        public ST(String st, int n){
            this.st = st;
            this.n = n;
        }
        @Override
        public int compareTo(ST o) {
            int thisSt = this.st.charAt(n);
            int oSt = o.st.charAt(n);
            if (thisSt == oSt) {
                for (int i = 0; i < st.length(); i++) {
                    if (this.st.charAt(i) != o.st.charAt(i)) {
                        return this.st.charAt(i) - o.st.charAt(i);
                    }
                }
                return 1;
            } else {
                return thisSt - oSt;
            }
        }
    }
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<ST> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(new ST(strings[i],n));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).st;
        }
//        for(String x : answer) System.out.println(x);
        return answer;
    }
    public static void main(String[] args) {
        // 예시 입력 1번 , return = {"car", "bed", "sun"}
//        String[] strings = {"sun", "bed", "car"};
        int n = 1;
//         예시 입력 2번 , return = {"abcd", "abce", "cdx"}
        String[] strings = {"abce", "abcd", "cdx"};
//        int n = 2;
        Solution12915 s = new Solution12915();
        s.solution(strings, n);
    }
}
