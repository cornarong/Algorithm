package algorithm09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 원더랜드(최소스패닝트리:크루스칼 알고리즘, Union & Find)
//최소 스패닝 트리의 정의는 그래프에서 그래프의 모든 정점을 연결하되,
//사이클이 존재하지 않도록 모든 정점을 간선으로 연결하는 것을 의미한다.
//이때, 간선의 가중치 합을 최소로 하며 연결하여야 한다.
//이때 생성되는 최소 스패닝 트리는 무조건 하나의 그래프에서 하나만 생성된다고는 보장하지 못한다.

public class Algorithm_09_07 {

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;
        public Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static int m;
    static int[] unf;
    static int unfCost;

    static void Solution(ArrayList<Edge> arr){
        for(Edge e : arr){
            Union(e.v1, e.v2, e.cost);
        }
        System.out.println(unfCost);
    }

    static int Find(int v){
        if(v == unf[v]){
            return unf[v];
        }else{
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int v1, int v2, int cost){
        int fV1 = Find(v1);
        int fV2 = Find(v2);
        if(fV1 != fV2){
            unf[fV1] = unf[fV2];
            unfCost += cost;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<Edge> arr = new ArrayList<>();
        unf = new int[n+1];
        for (int i = 0; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge(a,b,c));
        }
        Collections.sort(arr);
//        데이터 정렬 확인.
//        for(Edge e : arr){
//            System.out.println(e.v1+" : "+e.v2+" : "+e.cost);
//        }
        Solution(arr);
    }
}
