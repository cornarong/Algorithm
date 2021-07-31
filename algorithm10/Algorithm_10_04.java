package algorithm10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// ## 가장 높은 탑 쌓기 (LIS 응용) ##
// LIS (Longest Increasing Subsequence) : 최장 증가 수열
// * 다이나믹 배열
// * 초기값 셋팅
// * 1씩 증가하면서 안으로는 1씩 감소하면서 비교 (해당 값 기준 앞 인덱스 전부 비교)

public class Algorithm_10_04 {

    static class Point implements Comparable<Point> {
        int a;
        int h;
        int w;
        public Point(int a, int h, int w){
            this.a = a;
            this.h = h;
            this.w = w;
        }
        @Override
        public int compareTo(Point o) {
            return this.a - o.a;
        }
    }

    static int num;
    static int[] dy;

    static void Solution(ArrayList<Point> arr){
        dy[0] = arr.get(0).h; // 시작 셋팅
        int result = dy[0];

        for (int i = 1; i < num; i++) {
            int temp = arr.get(i).h;
            for (int j = i-1; j >= 0; j--) {
                if(arr.get(i).w > arr.get(j).w){
                    if(temp < dy[j] + arr.get(i).h) {
                        temp = dy[j] + arr.get(i).h;
                    }
                }
            }
            dy[i] = temp;
            result = Math.max(result, dy[i]);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        dy = new int[num];
        for (int i = 0; i < num; i++) {
            int a = sc.nextInt(); // 넓이
            int h = sc.nextInt(); // 높이
            int w = sc.nextInt(); // 무게
            arr.add(new Point(a, h, w));
        }
        Collections.sort(arr); // 넓이 기준 오름차순 정렬
        Solution(arr);
    }
}
