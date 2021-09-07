package programmers2;

import java.util.HashMap;


// ## [완전탐색] 소수 찾기 ##
// https://programmers.co.kr/learn/courses/30/lessons/42839
// https://cornarong.tistory.com/60 - 개인 블로그 정리

public class Solution42839 {
        int totalCnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        boolean isPrime(int num){
            for(int i=2; i*i<=num; i++){
                if(num % i == 0) return false;
            }
            return true;
        }

        void Permutation(String[] numArr, String[] resultArr, boolean[] visited, int depth, int end){
            int len = numArr.length;
            if(depth == end){
                String temp = "";
                for(String x : resultArr) {
                    temp += x;
                }
                // 가공 전 앞자리 '0' 체크
                while(temp.length() > 1 && temp.charAt(0) == '0'){
                    temp = temp.substring(1);
                }
                // 가공 후 앞자리 '0' 체크
                if(temp.equals("0") || temp.equals("1")) return;
                int resultNum = Integer.parseInt(temp);

                // 해쉬로 중복 체크
                map.put(resultNum, map.getOrDefault(resultNum, 0)+1);
                if(map.get(resultNum) == 1){
                    if(isPrime(resultNum)){
                        totalCnt++;
                    };
                }
                return;
            }else{
                for(int i=0; i<len; i++){
                    if(visited[i] == false){
                        visited[i] = true;
                        resultArr[depth] = numArr[i];
                        Permutation(numArr, resultArr, visited, depth+1, end);
                        visited[i] = false;
                    }
                }
            }
        }

        public int solution(String numbers) {
            int answer = 0;
            int len = numbers.length();
            String[] numArr = new String[len];

            for(int i=0; i < len; i++){
                numArr[i] = String.valueOf(numbers.charAt(i));
            }

            for(int i=0; i<len; i++){
                String[] resultArr = new String[i+1];
                boolean[] visited = new boolean[len];
                Permutation(numArr, resultArr, visited, 0, i+1);
            }
            answer = totalCnt;

            return answer;
        }

    public static void main(String[] args) {
        Solution42839 s = new Solution42839();
        // 예시 입출력
        String numbers = "17"; // return = 3
        //String numbers = "011"; // return = 2
        s.solution(numbers);

    }
}
