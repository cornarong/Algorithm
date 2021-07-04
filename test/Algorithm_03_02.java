package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// ## 공통원소 구하기 ##
// 교집합
public class Algorithm_03_02 {

    static void Solution(int aNum, int bNum, int[] aArr, int[] bArr) {

        //5
        //1 3 9 5 2
        //5
        //3 2 5 7 8
        int a = 0, b = 0;
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while (a < aNum && b < bNum) {
            if (aArr[a] == bArr[b]) {
                tempList.add(aArr[a]);
                a++;
                b++;
            } else if (aArr[a] > bArr[b]) {
                b++;
            } else {
                a++;
            }
        }
        for (int i = 0; i < tempList.size(); i++) {
            System.out.printf(tempList.get(i) + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int aNum = sc.nextInt();
        int[] aArr = new int[aNum];
        for (int i = 0; i < aNum; i++) {
            aArr[i] = sc.nextInt();
        }
        int bNum = sc.nextInt();
        int[] bArr = new int[bNum];
        for (int i = 0; i < bNum; i++) {
            bArr[i] = sc.nextInt();
        }
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        Solution(aNum, bNum, aArr, bArr);

/*        for (int i = 0; i < aNum; i++) {
            System.out.printf(aArr[i]+" ");
        }
        System.out.println("");
        for (int i = 0; i < bNum; i++) {
            System.out.printf(bArr[i]+" ");
        }*/

    }
}
