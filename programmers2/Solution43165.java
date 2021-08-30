package programmers2;

// ## [깊이/너비 우선 탐색(DFS/BFS)] 타겟 넘버 ##
// https://programmers.co.kr/learn/courses/30/lessons/43165

public class Solution43165 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0);
//        System.out.println(answer);
        return answer;
    }

    void DFS(int[] numbers, int target, int l){
        if(l == numbers.length){
            int sum = 0;
            for(int x : numbers) sum += x;
            if(sum==target) answer++;
        }else{
            numbers[l] *= 1; // 해당 배열의 요소를 +로
            DFS(numbers, target, l+1);
            numbers[l] *= -1; // 해당 배열의 요소를 -로
            DFS(numbers, target, l+1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        Solution43165 s = new Solution43165();
        s.solution(numbers, target);
    }
}
