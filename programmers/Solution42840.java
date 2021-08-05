package programmers;

import java.util.ArrayList;
import java.util.Collections;

// ## 모의고사 (완전탐색) ##
// https://programmers.co.kr/learn/courses/30/lessons/42840

public class Solution42840 {

    static int[] answers = {1,2,3,4,5};

    static class Score implements Comparable<Score>{
        int num;
        int score;
        public Score(int num, int score){
            this.num = num;
            this.score = score;
        }
        @Override
        public int compareTo(Score o) {
            return this.score - o.score;
        }
    }
    public int[] solution(int[] answers) {
        int[][] personPatten = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] answer = {};
        int i = 0, p1 = 0, p2 = 0, p3 = 0;
        for(int x : answers){
            if(personPatten[0][i % 5] == x) p1++;
            if(personPatten[1][i % 8] == x) p2++;
            if(personPatten[2][i % 10] == x) p3++;
            i++;
        }
        ArrayList<Score> arr = new ArrayList<>();
        arr.add(new Score(1,p1));
        arr.add(new Score(2,p2));
        arr.add(new Score(3,p3));
        Collections.sort(arr);
        Score max = Collections.max(arr);
        ArrayList<Integer> tempArr = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            if(arr.get(j).score == max.score){
                tempArr.add(arr.get(j).num);
            }
        }
        answer = new int[tempArr.size()];
        for (int j = 0; j < tempArr.size(); j++) {
            answer[j] = tempArr.get(j);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution42840 s = new Solution42840();
        s.solution(answers);
    }
}
