package programmers;

// ## [카카오 인턴] 키패드 누르기 ##
// https://programmers.co.kr/learn/courses/30/lessons/67256?language=java
public class Solution67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuffer answerTemp = new StringBuffer();
        int left = 10, right = 12; // 초기값 선언 후 로직에 따라 가장 최근 번호들이 들어갈 것.
        int leftDis = 0, rightDis = 0; // 거리를 담을 변수
        for(int num : numbers){
            if(num==1||num==4||num==7){
                left = num;
                answerTemp.append("L");
            }else if(num==3||num==6||num==9){
                right = num;
                answerTemp.append("R");
            }else{ // 키패드 가운데 라인일 경우
                leftDis = Distance(left, num, hand);
                rightDis = Distance(right, num, hand);
                if(leftDis>rightDis){
                    right = num;
                    answerTemp.append("R");
                }else if(leftDis<rightDis){
                    left = num;
                    answerTemp.append("L");
                }else{
                    if(hand.equals("left")){
                        left = num;
                        answerTemp.append("L");
                    }else{
                        right = num;
                        answerTemp.append("R");
                    }
                }
            }
        }
        answer = answerTemp.toString();
        return answer;
    }
    // 거리 구하는 함수
    static int Distance(int val, int num, String hand){
        // 키패드의 0번은 보이는 규칙에 따라 '10'을 준다.
        if(val == 0) val = 11;
        if(num == 0) num = 11;
        // left 또는 right의 좌표를 구한다.
        int x = (val-1) / 3;
        int y = (val-1) % 3;
        // 선택번호의 좌표를 구한다.
        int numX = num / 3;
        int numY = 1; // 가운데 라인 고정 '1'
        // 각각의 x, y의 절대값을 더한 후 반환해준다.
        return Math.abs(x-numX)+Math.abs(y-numY);
    }
    // 예시 2번 테스트
    public static void main(String[] args) {
        int [] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        Solution67256 s = new Solution67256();
        s.solution(numbers, hand);
    }
}
