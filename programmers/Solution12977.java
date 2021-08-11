package programmers;

// ## Summer/Winter Coding(~2018) 소수 만들기 ##
// https://programmers.co.kr/learn/courses/30/lessons/12977
public class Solution12977 {

    // 소수판별
    static Boolean isPrime(int sum){
        for(int i=2; i*i<=sum; i++){
            if(sum % i == 0) return false;
        }
        return true;
    }
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        int[] answerTemp = new int[3];
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    if(isPrime(nums[i]+nums[j]+nums[k])) answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 예시 1번
//        int[] num = {1,2,3,4};
        // 예시 2번
        int[] num = {1,2,7,6,4};
        Solution12977 s = new Solution12977();
        s.solution(num);
    }
}
