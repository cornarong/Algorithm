package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// ## 일곱 난쟁이 (브루트포스 알고리즘, 정렬) ##
// https://www.acmicpc.net/problem/2309

public class Main2309 {

    static boolean check = false;

    void DFS(int len, int[] nan, int[] nanTemp, int sum, int node){
        if(check) return;
        if(sum > 100) return;
        if(node == 7){
            if(sum == 100){
                Arrays.sort(nanTemp);
                for(int x : nanTemp) {
                    if(x!=0) System.out.println(x);
                }
                check = true;
            }
            return;
        }else{
            for (int i = 0; i < len; i++) {
                if(nanTemp[i] == 0){
                    nanTemp[i] = nan[i];
                    sum = sum+nan[i];
                    DFS(len, nan, nanTemp, sum, node+1);
                    sum = sum-nan[i];
                    nanTemp[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = 9;
        int[] nan = new int[len];
        int[] nanTemp = new int[len];

        for (int i = 0; i < len; i++) {
            nan[i] = sc.nextInt();
        }
        Main2309 T = new Main2309();
        T.DFS(len, nan, nanTemp,0, 0);

    }
}
