package programmers2;

import java.util.PriorityQueue;

// ## [힙(Heap)] 더 맵게 ##
// https://programmers.co.kr/learn/courses/30/lessons/cc
// *point : PriorityQueue

public class Solution42626 {
    public int solution(int[] scoville, int K) {
        int answer = -1, cnt = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int x : scoville) pQ.offer(x);
        while (pQ.peek() < K && pQ.size() > 1){
            int temp = pQ.poll() + (pQ.poll() * 2);
            cnt++;
            pQ.offer(temp);
            if(pQ.size()==1) break;
        }
        if(pQ.peek() >= K) answer = cnt;
        //System.out.println(cnt);
        return answer = pQ.peek() >= K ? cnt : -1;
    }
    public static void main(String[] args) {
        Solution42626 s = new Solution42626();
        // 예시 입력 / return = 2
        int[] scoville = {1,1,2};
//        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 3;
//        int K = 7;
        s.solution(scoville, K);
    }
}
