package algorithm09;

import java.util.*;

// ## 다익스트라 알고리즘 ##
// 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 만들어라.

// 1. 정점,거리비용을 담을 Point class 생성
// 2. Comparable의 compareTo를 이용하여 코스트 비용으로 내림차순 정렬시켜준다.
// 3. PriorityQueue로 Point를 객체로 받는 pQ 생성.
// 4. n+1크기의 dis배열를 만들어 MAX값으로 채운다. -> Arrays.fill(dis, Integer.MAX_VALUE);


public class Algorithm_09_05 {

    static class Point implements Comparable<Point>{
        int vex;
        int cost;
        public Point(int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    static int n; // 정점수
    static int m; // 간선수
    static int[] dis; // 다익스트라 배열 (인덱스 = 정점, 값 = 정점의 최소비용)
    static ArrayList<ArrayList<Point>> graph = new ArrayList<>(); // 2차원 리스트 (Point객체를 타입으로 갖는 ArrayList를 객체형으로 갖는 ArrayList)
    static PriorityQueue<Point> pQ = new PriorityQueue<>();
//    static Queue<Point> pQ = new LinkedList<>(); // 일반 큐도 가능하네?

    static void Solution(int v){
        dis[v] = 0; // 1번 위치의 거리비용은 0으로 시작.
        pQ.offer(new Point(v,dis[v])); // 1,0 을 넣고 시작.

        while(!pQ.isEmpty()){
            Point temp = pQ.poll();
            int nowVex = temp.vex;
            int nowCost = temp.cost;
            if(dis[nowVex] < temp.cost) continue; // 여기서 PriorityQueue를 활용한 이유가 나온다 (최소비용 값을 최대한 빨리 구하여 불필요한 시간복잡도를 줄인다)
            for(Point ob : graph.get(temp.vex)){
                if(dis[ob.vex] > nowCost+ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Point(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점수
        m = sc.nextInt(); // 간선수
        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Point>()); // 정점수만큼 arr안에 리스트를 만든다.
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Point(b, c));
        }

        Solution(1); // 시작 정점 1

        for (int i = 2; i <= n; i++) {
            if(dis[i] != Integer.MAX_VALUE){
                System.out.println(i+" : "+dis[i]);
            }else{
                System.out.println(i+" : "+"impossible");
            }
        }
    }
}
