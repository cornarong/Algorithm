import java.util.Scanner;

// ## 봉우리 ##
public class Algorithm_02_10 {

    static void Solution(int num, int[][] mount){

        int result = 0;
        for (int i = 1; i < num-1; i++) {
            for (int j = 1; j < num-1; j++) {
                if(mount[i][j] > mount[i][j-1] &&
                    mount[i][j] > mount[i][j+1] &&
                    mount[i][j] > mount[i-1][j] &&
                    mount[i][j] > mount[i+1][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num = num+2;
        int[][] mount = new int[num][num];
        for (int i = 1; i < num-1; i++) {
            for (int j = 1; j < num-1; j++) {
                mount[i][j] = sc.nextInt();
            }
        }
        Solution(num,mount);

    }
}
