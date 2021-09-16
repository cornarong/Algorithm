package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// ## 주유소 (그리디 알고리즘) ##
// https://www.acmicpc.net/problem/13305

public class Main13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 도시의 개수
        int n = Integer.valueOf(br.readLine());

        long[] disArr = new long[n-1];
        long[] priArr = new long[n];

        // 도시를 연결하는 도로의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < n-1; i++){
            int distance = Integer.valueOf(st.nextToken());
            disArr[i] = distance;

        }
        // 주유소의 리터당 가격(왼쪽 도시부터 순서대로)
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++){
            int price = Integer.valueOf(st.nextToken());
            priArr[i] = price;
        }

        long min = Long.MAX_VALUE;
        long price = 0;
        for(int i=0; i<n-1; i++) {
            if(min > priArr[i]) min = priArr[i];
            price += disArr[i] * min;
        }
        System.out.println(price);
    }
}
