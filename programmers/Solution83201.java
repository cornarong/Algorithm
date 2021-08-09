package programmers;

// ## [위클리 챌린지] 2주차 ##
// https://programmers.co.kr/learn/courses/30/lessons/83201
public class Solution83201 {
    public String solution(int[][] scores) {
        StringBuffer answerTemp = new StringBuffer();
        int len = scores.length;
        int[][] students = new int[len][len];
        int[] mySelf = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(i != j) {
                    students[i][j] = scores[j][i];
                }else{
                    mySelf[i] = scores[j][i];
                }
            }
        }
        int[] totalScore = new int[len];
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int cnt = len-1;
            for (int j = 0; j < len; j++) {
                if(students[i][j] != 0){
                    totalScore[i] += students[i][j];
                    min = Math.min(min,students[i][j]);
                    max = Math.max(max,students[i][j]);
                }
            }
            if(min<=mySelf[i] && mySelf[i]<=max){
                totalScore[i] += mySelf[i];
                cnt++;
            }
            int score = totalScore[i]/cnt;
            if(score >= 90){
                answerTemp.append("A");
            }else if(score >= 80 && score < 90){
                answerTemp.append("B");
            }else if(score >= 70 && score < 80){
                answerTemp.append("C");
            }else if(score >= 50 && score < 70){
                answerTemp.append("D");
            }else {
                answerTemp.append("F");
            }
        }
        String answer = answerTemp.toString();
        return answer;
    }
    public static void main(String[] args) {
        // 예시 1번 테스트
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
//        int[][] scores = {{50,90},{50,87}};
        Solution83201 s = new Solution83201();
        s.solution(scores);
    }


}
