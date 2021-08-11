package programmers;

// [2021 카카오 채용연계형 인턴십] 숫자 문자열과 영단어
// https://programmers.co.kr/learn/courses/30/lessons/81301
public class Solution81301 {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for (int i = 0; i < numbers.length; i++) {
            s = s.replaceAll(numbers[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
    public static void main(String[] args) {
        String s = "2three45sixseven";
        Solution81301 T = new Solution81301();
        T.solution(s);
    }
}
