package programmers;

// ## [2018 KAKAO BLIND RECRUITMENT] [1차] 다트 게임 ##
// https://programmers.co.kr/learn/courses/30/lessons/17682

// * char로 받은 숫자는 바로 int로 변환하여 받을 경우 아스키코드로 받게된다. (ex. 1->49)
// -> 따라서 (String.valueOf)스트링으로 변환한 후 int로 변환해서 받자.
public class Solution17682 {
    public int solution(String dartResult) {
        int answer = 0;
        char[] arr = dartResult.toCharArray();
        int[] result = new int[3];
        String temp = ""; // 획득 점수
        int ch = 0; // ch번쨰 기회
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '*'){
                result[ch-1] = result[ch-1]*2;
                if(ch-2 >= 0) result[ch-2] = result[ch-2]*2;
            }else if(arr[i] == '#'){
                result[ch-1] = -result[ch-1];
            }else{
                if(Character.isAlphabetic(arr[i])){
                    if(arr[i] == 'S') result[ch] = (int) Math.pow(Integer.parseInt(temp) ,1);
                    else if(arr[i] == 'D') result[ch] = (int) Math.pow(Integer.parseInt(temp),2);
                    else result[ch] = (int) Math.pow(Integer.parseInt(temp),3);
                    temp = "";
                    ch++;
                }else{
                    temp += Integer.parseInt(String.valueOf(arr[i]));
                }
            }
        }
        for(int x : result) answer += x;
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        // 예시 입력 1번, answer = 37
//        String dartResult = "1S2D*3T";
        // 예시 입력 2번, answer = 9
//        String dartResult = "1D2S#10S";
        // 예시 입력 3번, answer = 59
        String dartResult = "1D2S3T*";
        Solution17682 s = new Solution17682();
        s.solution(dartResult);

    }
}
