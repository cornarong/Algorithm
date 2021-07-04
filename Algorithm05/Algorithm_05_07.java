package Algorithm05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ## 교육과정 설계 ##
// 기존 Queue를 사용하여 로직일 구현하나
// 배열로 구현해도 충분히 문제 없을 것 같아 배열로 구현.

//만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C,B,A 과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
//여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
//현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
//C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
//수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
//수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
//필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.

// 예시 입력1
// CBA
// CBDAGE

// 예시 출력1
// YES

public class Algorithm_05_07 {

    static void Solution(String str1, String str2){

        // str1 = CBA 필수
        // str2 = CBDAGE 계획

        Queue<Character> queue = new LinkedList<>();
        StringBuffer result = new StringBuffer();
        // 1. str2를 한개씩 꺼내면서 str1 전체와 비교.
        // 2. 꺼낸 x가 str1에 포함된 문자면
        for (char x : str2.toCharArray()){
            for (int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i) == x) {
                    result.append(x);
                    break;
                }
            }
        }

        // StringBuffer로 생성된 객체는 String과 비교(equals)하기 위해선 toString()으로 변형이 필요하다.
        if(result.toString().equals(str1)) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        Solution(str1, str2);

    }


}
