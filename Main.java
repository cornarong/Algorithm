import java.util.Arrays;
import java.util.Scanner;

// ## 임시반장 정하기 ##
public class Main {

    static void Solution(int num, int[][] classNum){

        // 같은반이 었떤 친구는 제외 해야함.
        // 임시로 Arrays.fill로 대충 만듬. 수정필요

        int[] tempArr = new int[num];
        int[] students = new int[num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < num; k++) {
                    if(classNum[i][j] == classNum[k][j]){
                        if(tempArr[k] != 1){
                            students[i] += 1;
                            tempArr[k] = 1;
                        }
                    }
                }
            }
            Arrays.fill(tempArr, 0); // tempAarr배열 다시 0으로 초기화.
        }

        int temp = students[0];
        int student = 0;
        for (int i = 1; i < num; i++) {
            if(temp < students[i]){
                temp = students[i];
                student = i;
            }
        }
        System.out.println(student+1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] classNum = new int[num][5];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 5; j++) {
                classNum[i][j] = sc.nextInt();
            }
        }
        Solution(num,classNum);
    }
}
