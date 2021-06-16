import java.util.Scanner;

public class Algorithm_01_07 {

    static String Solution(String str){
        char[] chaArray = str.toCharArray();
        int lt = 0;
        int rt = chaArray.length-1;
        for(int i=0;i<chaArray.length;i++){
            if(Character.toUpperCase(chaArray[lt]) != Character.toUpperCase(chaArray[rt])){
                return "NO";
            }else{
                lt++;
                rt--;
            }
        }
        return "YES";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(Solution(str));
    }
}
