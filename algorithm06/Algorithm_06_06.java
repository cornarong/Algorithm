package algorithm06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// ## 장난 꾸러기 ##
public class Algorithm_06_06 {

    static void Solution(int n, int[] arr){

        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i] != arr2[i]) result.add(i+1);
        }
        for(int x : result) System.out.printf(x+" ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution(n, arr);
    }
}
