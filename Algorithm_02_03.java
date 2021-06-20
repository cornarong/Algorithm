import java.util.Scanner;

// ## 가위 바위 보 ##
// 다른방법 - if조건을 "비김"과 "A승리"만 비교 하고 else는 "B승리"
public class Algorithm_02_03 {

    static void Solution(int num, int[] arrA, int[] arrB){

        String[] result = new String[num];
        for (int i = 0; i < num; i++) {
            if(arrA[i] == 1 && arrB[i] == 2) result[i] = "B";
            else if(arrA[i] == 1 && arrB[i] == 3) result[i] = "A";
            else if(arrA[i] == 2 && arrB[i] == 1) result[i] = "A";
            else if(arrA[i] == 2 && arrB[i] == 3) result[i] = "B";
            else if(arrA[i] == 3 && arrB[i] == 1) result[i] = "B";
            else if(arrA[i] == 3 && arrB[i] == 2) result[i] = "A";
            else result[i] = "D";
        }
        for(String temp : result){
            System.out.println(temp);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arrA = new int[num];
        int[] arrB = new int[num];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < num; j++) {
                if(i == 0){
                    arrA[j] = sc.nextInt();
                }else{
                    arrB[j] = sc.nextInt();
                }
            }
        }
        Solution(num,arrA,arrB);
    }
}
