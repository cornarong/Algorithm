package backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


// ## 회의실 배정 (그리디 알고리즘, 정렬) ##
// https://www.acmicpc.net/problem/1931
// point - 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

public class Main1931 {

    static class Time implements Comparable<Time> {
        int st;
        int ed;

        public Time(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public int compareTo(Time o) {
            if(this.ed == o.ed){
                return this.st- o.st;
            }else{
                return this.ed - o.ed;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<Time> timeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            timeList.add(new Time(st, ed));
        }

        Collections.sort(timeList);

        int cnt = 1;
        int temp = 0;
        int start = timeList.get(0).st;
        int end = timeList.get(0).ed;
        temp = end;

        for (int i = 1; i < timeList.size(); i++) {
            start = timeList.get(i).st;
            end = timeList.get(i).ed;
            if(temp <= start){
                temp = end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
