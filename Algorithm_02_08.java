import java.util.Scanner;

// ## 등수 구하기 ##
// 예를 들어 5명이 입력 받았다고 하면
// --> 초기값으로 2중반복문전에 모두 1등으로 주고
// --> 2중반복문을 타면서 자기보다 큰 점수가 존재시 등수에 +1씩 누적한다.
public class Algorithm_02_08 {

    static void Solution(int num, int[] score){

        int temp = 1;
        int[] resultArr = new int[num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(i != j && score[i] < score[j]){
                    temp++;
                }
            }
            resultArr[i] = temp;
            temp = 1;
        }

        for (int i = 0; i < num; i++) {
            System.out.printf(resultArr[i]+" ");
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] score = new int[num];
        for (int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
        }
        Solution(num,score);

    }
}
