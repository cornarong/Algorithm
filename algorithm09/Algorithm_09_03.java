package algorithm09;

import java.util.ArrayList;
import java.util.Scanner;

// ## 결혼식 ##

public class Algorithm_09_03 {

    static class Time{
        int st,et;
        public Time(int st, int et){
            this.st = st;
            this.et = et;
        }
    }

    static int[] times;
    static ArrayList<Time> arr = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        times = new int[73];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = x; j <= y-1; j++) {
                times[j] += 1;
            }
//            arr.add(new Time(x, y));
        }

        int temp = times[0];
        for(int x : times){
            if(temp < x) temp = x;
        }
        System.out.println(temp);



    }
}
