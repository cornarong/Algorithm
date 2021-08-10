package programmers;

import java.util.Locale;

// [2021 KAKAO BLIND RECRUITMENT] 신규 아이디 추천
// https://programmers.co.kr/learn/courses/30/lessons/72410
public class Solution72410 {

    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase(Locale.ROOT);
        //1단계
        char[] idArr = new_id.toCharArray();
        StringBuffer sb = new StringBuffer();
        //2단계
        for(char c : idArr){
            if(!Character.isLetterOrDigit(c)){
                if(c!='-'&&c!='_'&&c!='.') continue;
            }
            sb.append(c);
        }
        //3단계
        idArr = sb.toString().toCharArray();
        sb = new StringBuffer();
        char temp = ' ';
        for (char c : idArr){
            if(c == '.' && temp == '.') continue;
            sb.append(c);
            temp = c;
        }
        //4단계
        if(!new_id.equals("")){
            if(sb.charAt(0)=='.') sb.deleteCharAt(0);
            if(sb.length()!=0 && sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        }
        //5단계
        if(sb.length() == 0) sb.append("a");
        //6단계
        if(sb.length() >= 16) {
            new_id = sb.toString().substring(0,15);
            if(new_id.charAt(14) == '.') new_id = new_id.substring(0,14);
        // 7단계
        }else if(sb.length() <= 2){
            char t = sb.charAt(sb.length()-1);
            while(sb.length() != 3){
                sb.append(t);
            }
            new_id = sb.toString();
        }else{
            new_id = sb.toString();
        }
        answer = new_id;
        return answer;
    }

    public static void main(String[] args) {

        // 예시 입력1
        Solution72410 s = new Solution72410();
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        s.solution(new_id);

    }
}