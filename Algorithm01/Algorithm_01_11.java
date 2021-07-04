package Algorithm01;

import java.util.Scanner;

// ## 문자열 압축 ##
// 방법1 -> for문을 index값+1 = length만큼 돌려서 마지막 index를 for문 안의 while문 안에 태워야 함.
//          같으면 i++ 로 건너 같은갯수 만큼 건너 뜀.
//          누적은 while문 밖에서 처리.
// 방법2 -> 처음 받은 string값에 +" "으로 공백값으로 인덱스 자리 하나 만든 후 for문으로 처리.
public class Algorithm_01_11 {

        static void Solution(String str){

            String result = "";
            int count = 1;

            for (int i = 0; i < str.length(); i++){
                while (i < str.length()-1){
                    if(str.charAt(i) == str.charAt(i+1)){
                        count++;
                        i++;
                    } else {
                        break;
                    }
                }
                result += str.charAt(i);
                if(count>1) result += String.valueOf(count);
                count = 1;
            }
            System.out.println(result);
        }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution(str);

    }
}
