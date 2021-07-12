package algorithm07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ## 그래프 최단거리 (BFS) ## - 인접행렬리스트
public class Algorithm_07_14 {
    static int n; // 정점 수
    static int m; // 간선 수
    static int[] ch; // 체크배열
    static int[] dis; // 거리배열
    static ArrayList<ArrayList<Integer>> graph; // 인접행렬리스트

    static void BPS(int v){ // 처음 값 = 1
        Queue<Integer> queue = new LinkedList<>(); // BFS니까 Queue생성.
        ch[v]=1; // 초기 설정. 1에서 시작하니 방문 체크.
        dis[v]=0; // 초기 설정. 1에서 1까지거리는 0이다.
        queue.offer(v); // 초기설정. 1번 정점 들어간다.
        while (!queue.isEmpty()){
            int cv = queue.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv] == 0){ // 방문 여부 확인.
                    ch[nv] = 1; // 0이면 1로 방문 체크.
                    queue.offer(nv); // 현재cv, 자식nv
                    dis[nv] = dis[cv]+1; // 중요포인트 , 현재 레벨+1
                }
            }
        }
    }
    public static void main(String[] args) {
        Algorithm_07_14 T = new Algorithm_07_14();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n+1]; // 체크배열
        dis = new int[n+1]; // 거리배열
        for (int i = 0; i < m; i++) { // 인접리스트 만듦.
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        T.BPS(1); // 1번 정점부터 출발해라.
    }

}