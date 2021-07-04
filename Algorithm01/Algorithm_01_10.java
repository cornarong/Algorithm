package Algorithm01;

import java.util.Scanner;

// ## 가장 짧은 문자거리 ##
public class Algorithm_01_10 {

    static void Solution(String str){

        String S = str.substring(0,str.indexOf(" "));
        char T = str.substring(str.indexOf(" ")+1).charAt(0);

        char[] SArray = S.toCharArray();
        int[] temp = new int[SArray.length];
        int count = 1000;

        for(int i=0;i<SArray.length;i++){
            if(SArray[i] == T){
                count = 0;
                temp[i] = count;
            } else {
                count++;
                temp[i] = count;
            }
        }

        count = 1000;
        for(int i=SArray.length-1; i>=0; i--){
            if(SArray[i] == T){
                count = 0;
                temp[i] = count;
            } else {
                count++;
                if(temp[i] > count) {
                    temp[i] = count;
                }
            }
        }
        for(int x : temp){
            System.out.print(x+" ");

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution(str);
    }
}
