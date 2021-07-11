package algorithm07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ## 송아지 찾기 1 (BFS:상태트리탐색) ##
public class Algorithm_07_08 {

    int[] arr = {1, -1, 5}; // 뻗어나갈 3가지 자식노드
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {

        int[] check = new int[10001];
        check[s] = 1;
        Q.offer(s);
        int Level = 0;
        while (!Q.isEmpty()) {
        int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + arr[j]; // 6, 4, 10
                    if(nx == e) return Level+1;
                    if (check[nx] == 0 && nx <= 10000 && nx >= 1) { // 여기서 nx <= 10000 && nx >= 1 조건여부로 유무로 runtime 발생함..
                        Q.offer(nx);
                        check[nx] = 1;
                    }
                }
            }
            Level++;
        }
        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Algorithm_07_08 T = new Algorithm_07_08();
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s, e));

    }
}
