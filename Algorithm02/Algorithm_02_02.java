package Algorithm02;

import java.util.Scanner;

// ## 보이는 학생 ##
public class Algorithm_02_02 {

    static void Solution(int num, int[] students){

        int cnt = 1;
        int temp = students[0];
        for (int i = 1; i < num; i++) {
            if(temp < students[i]){
                temp = students[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] students = new int[num];
        for (int i = 0; i < num; i++) {
            students[i] = sc.nextInt();
        }
        Solution(num,students);
    }
}
