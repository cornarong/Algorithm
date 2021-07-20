package algorithm09;

import java.util.*;


// ## 회의실 배정 (Greedy) ##
// 회의가 빨리 끝나는 것부터 처리해야 최상의 결과가 나온다 - 그리디 기법
public class Algorithm_09_02 {

    static class Time implements Comparable<Time>{
        int st;
        int et;
        public Time(int st, int et){
            this.st = st;
            this.et = et;
        }
        @Override
        public int compareTo(Time t) {
            if(this.et == t.et){
                return this.st - t.st;
            }else{
                return this.et - t.et;
            }
        }
    }

    static int n;
    static int sum = 0;

    static ArrayList<Time> timeArr = new ArrayList<>();
    static void Solution(){
        int temp = 0;
        for(Time t : timeArr){
            if(temp <= t.st){
                temp = t.et;
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            timeArr.add(new Time(a, b));
        }
        Collections.sort(timeArr);
        Solution();
    }
}