package programmers;

import java.util.HashMap;

// ## [해시] 완주하지 못한 선수 ##
// https://programmers.co.kr/learn/courses/30/lessons/42576
public class Solution42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hash = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            hash.put(participant[i],hash.getOrDefault(participant[i],0)+1);
        }
        for (int i = 0; i < completion.length; i++) {
            hash.put(completion[i],hash.get(completion[i])-1);
        }
        for (String x : hash.keySet()){
            if(hash.get(x) >= 1){
                answer = x;
                break;
            }
        }
        // hash 확인
//        for (String x : hash.keySet()) System.out.println(x+"="+hash.get(x));
        return answer;
    }

    public static void main(String[] args) {
        Solution42576 s = new Solution42576();
        // 예시 2번
//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        // 예시 3번 (동명이인 선수)
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        s.solution(participant, completion);
    }
}
