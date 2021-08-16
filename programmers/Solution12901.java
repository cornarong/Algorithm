package programmers;

import java.util.HashMap;

// ## [연습문제] 2016년 ##
// https://programmers.co.kr/learn/courses/30/lessons/12901?language=java
// 윤년 = 2월이 29일까지.
public class Solution12901 {
    public String solution(int a, int b) {
        String answer = "";
        String[] arr = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        HashMap<Integer,Integer> month = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            if(i==4||i==6||i==9||i==11){
                month.put(i,30);
            }else if(i==2){
                month.put(i,29);
            }else{
                month.put(i,31);
            }
        }
        int ch = 0;
        for (int i = 0; i < month.size(); i++) {
            int day = month.get(i+1);
            for (int j = 1; j <= day; j++) {
                if(ch==7) ch=0;
                if(a==i+1 && b==j) {
                    return answer = arr[ch];
                }
                ch++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        // 예시 입력 / result = "TUE"
        int a = 5;
        int b = 24;
        Solution12901 s = new Solution12901();
        s.solution(a, b);
    }
}
