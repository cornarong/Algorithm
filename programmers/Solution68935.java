package programmers;

// ## [월간 코드 챌린지 시즌1] 3진법 뒤집기 ##
// https://programmers.co.kr/learn/courses/30/lessons/68935
public class Solution68935 {

// StringBuilder 사용
    public int solution(int n) {
        String temp = Integer.toString(n,3);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) sb.append(temp.charAt(i));
        int answer = Integer.parseInt(sb.reverse().toString(),3);
        return answer;
    }

//stack 사용
/*    public int solution(int n) {
        String temp = Integer.toString(n,3);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < temp.length(); i++) {
            stack.push(temp.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().toString());
        }
        int answer = Integer.parseInt(sb.toString(),3);
        return answer;
    }*/

    public static void main(String[] args) {
        // 예시 입출력
        int n = 45; // result = 7
        // int n = 125; // result = 229
        Solution68935 s = new Solution68935();
        s.solution(n);
    }
}
