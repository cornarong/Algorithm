package programmers;

// ## 음양 더하기 ##
// https://programmers.co.kr/learn/courses/30/lessons/76501

public class Solution76501 {

    static int[] absolutes = {4,7,12};
    static boolean[] signs = {true,false,true};

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0, index = 0;
        for(Boolean x : signs){
           if(x == true) answer += absolutes[index];
           else answer -= absolutes[index];
           index++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution76501 s = new Solution76501();
        s.solution(absolutes,signs);
    }
}
