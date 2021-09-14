package backjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// ## ATM (그리디 알고리즘, 정렬) ##
// https://www.acmicpc.net/problem/11399

public class Main11399 {

    public static void main(String[] args) {

        HashMap<Integer,Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pArr = new int[n];
        for (int i = 0; i < n; i++) {
            pArr[i] = sc.nextInt();
        }
        Arrays.sort(pArr);

        int stepSum = 0;
        for (int i = 0; i < n; i++) {
            stepSum += pArr[i];
            map.put(i+1, stepSum);
        }

        int minSum = 0;
        for(int x : map.keySet()) minSum += map.get(x);
        System.out.println(minSum);
    }
}
