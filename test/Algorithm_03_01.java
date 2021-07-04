package test;

import java.util.Arrays;
import java.util.Scanner;


// 두 배열 합치기
// System.arraycopy 사용!
// 1. 합칠 두 배열의 길이를 더한 새로운 배열 생성.
// 2. System.arraycopy(A, 0번부터, C, 0번부터, A의길이); -> A배열의 0번 부터를 ~ C배열에 0번부터 A의 길이만큼 넣는다.
// 3. System.arraycopy(B, 0번부터, C, A의길이, B의길이); -> B배열의 0번 부터를 ~ C배열의 A의 길이부터 B의 길이만큼 넣는다.
public class Algorithm_03_01 {

    static void Solution(int numA, int numB, int[] ArrayA, int[] ArrayB){

        int num = numA+numB;
        int[] sumArray = new int[num];

        System.arraycopy(ArrayA, 0, sumArray, 0, ArrayA.length);
        System.arraycopy(ArrayB, 0, sumArray, ArrayA.length, ArrayB.length);

        Arrays.sort(sumArray);

        for (int i = 0; i < num; i++) {
            System.out.printf(sumArray[i]+" ");
        }






    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numA = sc.nextInt();
        int[] ArrayA = new int[numA];
        for (int i = 0; i < numA; i++) {
            ArrayA[i] = sc.nextInt();
        }
        int numB = sc.nextInt();
        int[] ArrayB = new int[numB];
        for (int i = 0; i < numB; i++) {
            ArrayB[i] = sc.nextInt();
        }

/*        for (int i = 0; i < numA; i++) {
            System.out.printf(ArrayA[i]+" ");
        }
        System.out.println("");
        for (int i = 0; i < numB; i++) {
            System.out.printf(ArrayB[i]+" ");
        }*/
        Solution(numA,numB,ArrayA,ArrayB);

    }
}
