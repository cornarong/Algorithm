package algorithm09;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 원더랜드(최소스패닝트리:프림 알고리즘,PriorityQueue)
//최소 스패닝 트리의 정의는 그래프에서 그래프의 모든 정점을 연결하되,
//사이클이 존재하지 않도록 모든 정점을 간선으로 연결하는 것을 의미한다.
//이때, 간선의 가중치 합을 최소로 하며 연결하여야 한다.
//이때 생성되는 최소 스패닝 트리는 무조건 하나의 그래프에서 하나만 생성된다고는 보장하지 못한다.

public class Algorithm_09_08 {

    static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;
        public Edge(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            // 유지비용 내림차 정렬
            return this.cost - o.cost;

        }
    }

    static int v;
    static int e;
    static PriorityQueue<Edge> pQ = new PriorityQueue<>();
    static ArrayList<ArrayList<Edge>> arr = new ArrayList<>();
    static int[] ch;
    static int result = 0;

    static void Solution(int v){

        ch[v] = 1;
        for (Edge e : arr.get(v)) pQ.offer(e);

        while(!pQ.isEmpty()){
            Edge temp = pQ.poll();
            if(ch[temp.vertex] == 0){
                ch[temp.vertex] = 1;
                result += temp.cost;
                for (Edge e : arr.get(temp.vertex)) {
                    if(ch[e.vertex] == 0){
                        pQ.offer(e);
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        v = sc.nextInt(); // 도시갯수(정점)
        e = sc.nextInt(); // 도로의 갯수(간선)
        ch = new int[v+1];
        for (int i = 0; i <= v; i++) {
            arr.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            // 무방향이라 양쪽을 넣는다.
            arr.get(v1).add(new Edge(v2, cost));
            arr.get(v2).add(new Edge(v1, cost));
        }
        Solution(1);
    }
}
