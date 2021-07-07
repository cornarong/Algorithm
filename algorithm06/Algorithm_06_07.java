package algorithm06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// ## 좌표정렬 ##
class Point implements Comparable<Point>{
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        // 1. call한 자신객체와 매개변수로 넘어온 o객체를 비교한다.
        // 2. this.x에서 o.x을 뺀 return값이 양수일 경우 자리를 교체한다. 그외는 제자리에 위치한다. -> 오름차순
        // 3. 반대로 내림차순으로 정렬하고 싶다면 o.x에서 this.x의 값을 빼면된다.
        if (this.x == o.x) { // x좌표의 값이 같으면 y좌표의 값으로 정렬
            return this.y - o.y;
        } else { // 그외 x좌표를 기준으로 정렬
            return this.x - o.x;
        }
    }
}

public class Algorithm_06_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>(); // Point객체를 담을 ArrayList를 생성한다.
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y)); // ArrayList에 Point객체를 생성해서 담아준다.
        }
        // overrride한 compareTo의 구현에 따라 sort가 정렬을 해준다.
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x + " " + o.y);
    }
}
