package programmers2;

import java.util.LinkedList;
import java.util.Queue;

// ## [스택/큐] 프린터 ##
// https://programmers.co.kr/learn/courses/30/lessons/42587

public class Solution42587 {

    class Printer{
        int num;
        int index;
        public Printer(int num, int index){
            this.num = num;
            this.index = index;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        boolean check = true;
        Queue<Printer> Q = new LinkedList<>();

        for(int i=0; i < priorities.length; i++){
            Q.offer(new Printer(priorities[i], i));
        }

        while(!Q.isEmpty()){
            check = true;
            Printer o = Q.poll();
            for(Printer p : Q){
                if(p.num > o.num){
                    Q.offer(new Printer(o.num, o.index));
                    check = false;
                    break;
                }
            }
            if(check == true){
                answer++;
                if(o.index == location) break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution42587 s = new Solution42587();
        // 예시 입력 1번 / return = 1
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        // 예시 입력 2번 / return = 5
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;
        s.solution(priorities, location);
    }
}
