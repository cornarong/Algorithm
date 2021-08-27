package programmers2;

import java.util.LinkedList;
import java.util.Queue;

// ## [스택/큐] 기능개발 ##
// https://programmers.co.kr/learn/courses/30/lessons/42586

public class Solution42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] tempArr = new int[progresses.length];
        Queue<Integer> dayQueue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0){
                tempArr[i] = (100 - progresses[i]) / speeds[i];
            }else{
                tempArr[i] = ((100 - progresses[i]) / speeds[i])+1;
            }
        }
        for (int i = 0; i < tempArr.length; i++) {
            int temp = tempArr[i];
            int cnt = 1;
            for (int j = i; j < tempArr.length; j++) {
                if(i == j) continue;
                if(temp >= tempArr[j]){
                   cnt++;
                   i = j;
                }else break;
            }
            dayQueue.offer(cnt);
        }
        int[] answer = new int[dayQueue.size()];
        int index = 0;
        while (!dayQueue.isEmpty()){
            answer[index] = dayQueue.poll();
            index++;
        }
//        for(int x : answer) System.out.println(x);
        return answer;
    }
    public static void main(String[] args) {
        Solution42586 s = new Solution42586();
        // 예시 입력 / retrun = {1, 3, 2}
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        s.solution(progresses, speeds);
    }
}
