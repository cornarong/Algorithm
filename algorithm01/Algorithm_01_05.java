package algorithm01;

import java.util.Scanner;
import java.util.Stack;

public class Algorithm_01_05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char x : arr){
            if(Character.isAlphabetic(x)) stack.push(x);
        }
        for (int i = 0; i < arr.length; i++) {
            if(Character.isAlphabetic(arr[i])){
                arr[i] = stack.pop();
            }
        }
        String result = String.valueOf(arr);
        System.out.println(result);
        // a#b!GE*T@S

    }
}
