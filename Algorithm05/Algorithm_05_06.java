package Algorithm05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ## 공주 구하기 (Queue) ##

//element() - 저장된 요소를 불러온다.
//offer() - Queue에 객체 저장 ( true : 성공, false : 실패 ) 반환
//peek() - 저장된 객체를 반환 / 없을경우 Null 을 반환
//poll() - 객체를 꺼내온다 / 꺼낸 객체는 사라진다.

public class Algorithm_05_06 {

    static void Solution(int n, int k){
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        while (queue.size() != 1){
            cnt++;
            if(cnt == k) {
                queue.poll();
                cnt = 0;
            } else {
                queue.offer(queue.peek());
                queue.poll();
            }
        }

        System.out.println(queue.peek()+1);



    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution(n ,k);

    }
}
