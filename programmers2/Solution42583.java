package programmers2;

// ## [스택/큐] 다리를 지나는 트럭 ##
// https://programmers.co.kr/learn/courses/30/lessons/42583

import java.util.LinkedList;
import java.util.Queue;

public class Solution42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> tq = new LinkedList<>();

        for(int i=0; i<truck_weights.length; i++){
            tq.offer(truck_weights[i]);
        }

        while(true){
            if(q.isEmpty()){
                q.offer(tq.poll());
                answer++;
            }else if(q.size() == bridge_length){
                if(tq.isEmpty()){
                    for(int x : q) answer++;
                    break;
                }else{
                    q.poll();
                }
            }else if(!q.isEmpty()){
                int temp = 0;
                for(int x : q){
                    temp += x;
                }
                if(!tq.isEmpty() && temp + tq.peek() <= weight){
                    q.offer(tq.poll());
                    answer++;
                }else{
                    if(!tq.isEmpty()){
                        q.offer(0);
                        answer++;
                    }else{
                        q.offer(0);
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution42583 s = new Solution42583();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        s.solution(bridge_length, weight, truck_weights);

    }
}
