package programmers2;

// ## [연습문제] JadenCase 문자열 만들기 ##
// https://programmers.co.kr/learn/courses/30/lessons/12951?language=java#

public class Solution12951 {

    public String solution(String s) {

        String answer = "";
        StringBuffer sb = new StringBuffer();
        String[] temp = s.split(" ");
        for(int i=0; i<temp.length; i++){
            for(int j=0; j<temp[i].length(); j++){
                if(j==0){
                    sb.append(Character.toUpperCase(temp[i].charAt(j)));
                }else{
                    sb.append(Character.toLowerCase(temp[i].charAt(j)));
                }
            }
            if(i!=temp.length-1) sb.append(" ");
        }
        answer = sb.toString();
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution12951 S = new Solution12951();
        S.solution("3people unFollowed me"); // return : 3people Unfollowed Me
    }
}
