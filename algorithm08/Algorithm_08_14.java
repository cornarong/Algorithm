package algorithm08;

import java.util.*;

// ## 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용) ##
class Algorithm_08_14 {

    static class Point {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, len, answer=Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> hs, pz;
    public void DFS(int L, int s){
        if(L==m){ // 조합이 하나 완성되면 탄다.
            int sum=0;
            for(Point h : hs){ // 하우스를 하나 씩 꺼낸다.
                int dis=Integer.MAX_VALUE;
                for(int i : combi){ // 조합의 값을 하나씩 꺼낸다.
                    dis=Math.min(dis, Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y)); // abs : 절대값 반환 함수
                }
                sum+=dis;
            }
            answer=Math.min(answer, sum);
        }
        else{
            for(int i=s; i<len; i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args){
        Algorithm_08_14 T = new Algorithm_08_14();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        pz=new ArrayList<>();
        hs=new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp=kb.nextInt();
                if(tmp==1) hs.add(new Point(i, j)); //  하우스면 리스트에 좌표를 담는다.
                else if(tmp==2) pz.add(new Point(i, j)); // 피자집이면 리스트에 좌표를 담는다.
            }
        }
        len=pz.size();
        combi=new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}