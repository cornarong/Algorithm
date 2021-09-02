package programmers2;

// ## [2018 KAKAO BLIND RECRUITMENT] [1차]뉴스 클러스터링 ##
// https://programmers.co.kr/learn/courses/30/lessons/17677

import java.util.HashMap;

public class Solution {

    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // str1
        for (int i = 0; i < str1.length() - 1; i++) {
            if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) {
                String temp = str1.charAt(i) + "" + str1.charAt(i + 1);
                sb1.append(temp + ",");
            }
        }

        // str2
        for (int i = 0; i < str2.length() - 1; i++) {
            if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) {
                String temp = str2.charAt(i) + "" + str2.charAt(i + 1);
                sb2.append(temp + ",");
            }
        }

        HashMap<String, Integer> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();

        if (sb1.length() > 1) sb1.deleteCharAt(sb1.length() - 1);
        String[] arr1 = sb1.toString().split(",");
        if (sb2.length() > 1) sb2.deleteCharAt(sb2.length() - 1);
        String[] arr2 = sb2.toString().split(",");

        for (int i = 0; i < arr1.length; i++) {
            hash1.put(arr1[i], hash1.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < arr2.length; i++) {
            hash2.put(arr2[i], hash2.getOrDefault(arr2[i], 0) + 1);
        }

        float set1 = 0, set2 = 0;
        for (String s : hash1.keySet()) {
            if (hash2.get(s) != null) {
                set1 += Math.min(hash1.get(s), hash2.get(s));
                set2 += Math.max(hash1.get(s), hash2.get(s));
            } else {
                set2 += hash1.get(s);
            }
        }
        for (String x : hash2.keySet()) {
            if (hash1.get(x) == null) {
                set2 += hash2.get(x);
            }
        }

        if((set1 == 0 && set2 == 0) || (set1 != 0 && set2 == 0)) {
            answer = 65536;
        }else {
            answer = (int) ((set1 / set2) * 65536);
        }

        return answer;
    }

    public static void main(String[] args) {

        // 예시 입력 1번 / answer = 16384
        String str1 = "FRANCE";
        String str2 = "french";
        Solution s = new Solution();
        s.solution(str1, str2);

    }
}
