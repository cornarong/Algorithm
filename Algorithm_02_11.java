import java.util.Scanner;

// ## 임시반장 정하기 ##
public class Algorithm_02_11 {

    static void Solution(int num, int[][] classNum) {

        // 처음 시작점 한명의 학생으로 다른 한명의과 한 학년씩 비교할 것임.
        int tempCnt = 0;
        int student = 0;
        for (int i = 1; i <= num; i++) { // 시작학생 반복
            int cnt = 0;
            for (int j = 1; j <= num; j++) { // 비교학생 반복
                for (int k = 1; k < 6; k++) { // 비교학년 반복, 학년은 5학년으로 고정
                    if(classNum[i][k] == classNum[j][k]){
                        cnt++;
                        break; // 같은 반이었던 학생 나올 경우 멈춤. 중복제거 위함.
                    }
                }
            }
            if(cnt>tempCnt){ // 이전 시작학생과 현재 시작학생의 누적값 비교
                tempCnt = cnt;
                student = i;
            }
        }
        System.out.println(student);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] classNum = new int[num+1][6];
        for (int i = 1; i < num+1; i++) {
            for (int j = 1; j < 6; j++) {
                classNum[i][j] = sc.nextInt();
            }
        }
        Solution(num,classNum);


    }
}