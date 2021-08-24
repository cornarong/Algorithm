package programmers2;

// ## [2017 카카오코드 예선] 카카오프렌즈 컬러링북 ##
// https://programmers.co.kr/learn/courses/30/lessons/1829
// https://cornarong.tistory.com/54 - 개인 블로그 정리

public class Solution1829 {
    static int[][] tempPickture;
    static int[] upDown = {1,-1,0,0};
    static int[] leftRihgt = {0,0,1,-1};
    static int cnt = 1;

    static void findArea(int m, int n, int x, int y,int[][] picture){
        for (int i = 0; i < 4; i++) {
            int tempX = x + upDown[i];
            int tempY = y + leftRihgt[i];
            if(0 <= tempX && 0 <= tempY && tempX < m && tempY < n
                    && picture[x][y] == picture[tempX][tempY] && tempPickture[tempX][tempY] == 0){
                cnt++;
                tempPickture[tempX][tempY] = 1;
                findArea(m, n, tempX, tempY, picture);
            }
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        tempPickture = new int[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && tempPickture[i][j] == 0){
                    tempPickture[i][j] = 1;
                    findArea(m, n, i ,j,picture);
                    maxSizeOfOneArea = Math.max(cnt,maxSizeOfOneArea);
                    numberOfArea++;
                    cnt = 1;
                }
            }
        }
//        System.out.println("numberOfArea > "+numberOfArea);
//        System.out.println("maxSizeOfOneArea > "+maxSizeOfOneArea);
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        Solution1829 s = new Solution1829();
        // 예시 입력 / 출력 answer = {4,5}
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        s.solution(m, n, picture);
    }
}
