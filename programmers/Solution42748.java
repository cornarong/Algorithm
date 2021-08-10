package programmers;

import java.util.Arrays;

// ## k번째 수 ##
//https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
public class Solution42748 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start = 0, end = 0, select = 0;
        for (int i = 0; i < commands.length; i++) {
            start = commands[i][0]; // 시작
            end = commands[i][1]; // 끝
            select = commands[i][2]; // 선택
            int[] arrayTemp = new int[(end-start)+1];
            int cnt = 0;
            for (int j = start-1; j < end; j++) {
                arrayTemp[cnt] = array[j];
                cnt++;
            }
            Arrays.sort(arrayTemp);
            answer[i] = arrayTemp[select-1];
        }
        return answer;
    }

    // 예시 입출력1
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution42748 s = new Solution42748();
        s.solution(array, commands);

    }
}
