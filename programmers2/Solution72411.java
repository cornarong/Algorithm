package programmers2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// ## [2021 KAKAO BLIND RECRUITMENT] 메뉴 리뉴얼 ##
// https://programmers.co.kr/learn/courses/30/lessons/72411
// https://cornarong.tistory.com/57 - 개인 블로그 정리

public class Solution72411 {

    HashMap<String,Integer> hash;
    // 조합 알고리즘 (백 트래킹)
    void combination(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            char[] tempArr = new char[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]) tempArr[i] = arr[i];
            }
            Arrays.sort(tempArr);
            StringBuilder sb = new StringBuilder();
            for(char x : tempArr) {
                if(x!='\0'){ // char배열 선언시 초기값 '\0'
                    sb.append(x);
                }
            }
            hash.put(sb.toString(),hash.getOrDefault(sb.toString(),0)+1);
            return;
        }else{
            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            hash = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                char[] arr = orders[j].toCharArray();
                boolean[] visited = new boolean[arr.length];
                combination(arr, visited, 0,orders[j].length(),course[i]);
            }
            int Max = 0;
            for(int x : hash.values()){
                if(x < 2) continue;
                Max = Math.max(Max, x);
            }
            for(String x : hash.keySet()){
                if(hash.get(x) == Max) {
                    list.add(x);
                }
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        for(String s : answer) System.out.println(s);
        return answer;
    }

    public static void main(String[] args) {
        Solution72411 s = new Solution72411();

        // 예시 입출력 1번
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4}; // result = {"AC", "ACDE", "BCFG", "CDE"}

        // 예시 입출력 2번
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2,3,5}; // result = {"ACD", "AD", "ADE", "CD", "XYZ"

        // 예시 입출력 3번
//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2,3,4}; // result = {"WX", "XY"}

        s.solution(orders, course);
    }
}
