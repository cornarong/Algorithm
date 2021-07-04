package Algorithm02;

import java.util.Scanner;

// ## 큰 수 출력하기 ##
// for문으로 숫자 2개씩 비교위해 입력받은 str에 0추가.
public class Algorithm_02_01 {

    static void Solution(int num, String str){
        str = str+" 0";
        String[] temp = str.split(" ");
        String result = temp[0];

        for (int i = 0; i < num; i++) {
            if(Integer.parseInt(temp[i]) < Integer.parseInt(temp[i+1])){
                result += " "+temp[i+1];
            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        Solution(num,str);

    }
}
