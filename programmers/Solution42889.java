package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// ## [2019 KAKAO BLIND RECRUITMENT] 실패율 ##
// https://programmers.co.kr/learn/courses/30/lessons/42889?language=java

public class Solution42889 {
    static class St implements Comparable<St> {
        int stage;
        double fail;
        public St(int stage, double fail) {
            this.stage = stage;
            this.fail = fail;
        }
        @Override
        public int compareTo(St o) {
            if (this.fail == o.fail) {
                return this.stage - o.stage;
            } else {
                if (this.fail > o.fail) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < stages.length; i++) {
            hash.put(stages[i], hash.getOrDefault(stages[i], 0) + 1);
        }
        Double users = (double) stages.length;
        ArrayList<St> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (hash.get(i) == null) {
                arr.add(new St(i, 0));
//                System.out.println(i+"번 스테이지 0명");
            } else {
                Double fail = (double) hash.get(i) / users;
                arr.add(new St(i, fail));
//                System.out.println(i+"번 스테이지 실패율="+fail);
                users = users - hash.get(i);
            }
        }
        Collections.sort(arr);
        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).stage;
        }
        return answer;
    }
    public static void main(String[] args) {
        // 예시 입력, 출력 result = 3,4,2,1,5
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        Solution42889 s = new Solution42889();
        s.solution(N, stages);
    }
}