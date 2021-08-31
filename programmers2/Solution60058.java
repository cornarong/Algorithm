package programmers2;

import java.util.LinkedList;
import java.util.Queue;

// ## [2020 KAKAO BLIND RECRUITMENT] 괄호 변환 ##
// https://programmers.co.kr/learn/courses/30/lessons/60058
// 2시간소요. 정리한번 하기.

public class Solution60058 {

    String DFS(Queue<Character> Q){
        int left = 0, right = 0, ch = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        while(!Q.isEmpty()){
            char temp = Q.poll();

            if(temp=='(') left++;
            if(temp==')') right++;

            if(ch == 0) u.append(temp);
            if(ch == 1) v.append(temp);
            if(left != 0 && left == right) ch = 1;
        }
        if(u.length() > 1 && u.charAt(0) == ')'){

            StringBuilder sb2 = new StringBuilder();
            sb2.append('(');
            for(char s : v.toString().toCharArray()) Q.offer(s);
            sb2.append(DFS(Q));
            sb2.append(')');

            String t = u.toString();
            String temp = "";
            t = (t.substring(1,t.length()-1));
            for (int i = 0; i < t.length(); i++) {
                if(t.charAt(i) == '('){
                    temp += ')';
                }else{
                    temp += '(';
                }
            }
            u = sb2.append(temp);

        } else if(u.length() > 1 && u.charAt(0) == '('){
            if(v.length() == 0) {
                return u.toString();
            }else{
                for (int i = 0; i < v.length(); i++) Q.offer(v.charAt(i));
                u = u.append(DFS(Q));
            }
        }
        return u.toString();
    }

    public String solution(String p) {
        String answer = "";
        Queue<Character> Q = new LinkedList<>();
        char[] pArr = p.toCharArray();
        for(char x : pArr) Q.offer(x);
        // u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        if(p.length() < 2) {
            answer  = "";
        }else{
            answer = DFS(Q);
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        Solution60058 s = new Solution60058();
        String p = "()))((()"; // result = "()(())()"
//        String p = ")()()()("; // result = "(()())()"
        s.solution(p);
        /*String t = "))((";
        t = (t.substring(1,t.length()-1)).replace(")(","()");
        System.out.println(t);*/
    }
}
