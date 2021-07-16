package algorithm08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ## 미로의 최단거리 통로(BFS) ##
// 좌표는 1,1부터 n,n까지 이므로 2차원 배열을 [n+1][n+1]크기로 만든다.
// BFS는 while문과 Queue를 가지고 진행한다.
// while에 Queue가 비게되면 중단.
// 좌표 이동은 dx,dy 배열을 만든다 (상,하,좌,우)
// 실제 좌표 값을 가진 배열 한개와 같은 크기의 빈 배열을 만든다.
// 시작점인 1,1좌표를 시작으로 한다.
// Queue에서 꺼낸 값을 반복문안에서 상하좌우 체크하면서
// nx와 ny를 만들면서 nx가 0이거나 ny가 0인 값은 반복문 안에서 배제시킨다.
// 다음 좌표(nx,ny)가 이동이 가능하면 Queue에 넣는다.
// Queue에 넣으면서 해당 좌표는 벽 처리 한다.
// dis배열은 1,1이 0을 시작으로 이전 좌표값 +1로 거리를 누적시킨다.

public class Algorithm_08_11 {

    static class Point{ // 좌표를 담을 클래스
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Point> Q = new LinkedList<>();
    static int[][] board; // 실제 좌표 값 배열 (지나간곳은 벽=1 처리)
    static int[][] dis; // 좌표 크기의 빈 배열 (거리 누적)
    static int[] dx = {-1, 1, 0, 0}; // 상 하
    static int[] dy = {0, 0, -1, 1}; // 좌 우

    static void BFS(int x, int y){
        Q.offer(new Point(x,y)); // 시작점 1,1, 넣는다.
        board[x][y] = 1; // 시작점 벽 처리.

        while (!Q.isEmpty()){
            Point temp = Q.poll(); // 큐에서 하나 꺼내고
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx >= 1 && nx <= 7  && ny >=1 && ny <= 7 && board[nx][ny] == 0){
                    Q.offer(new Point(nx,ny)); // Q에서 넣고
                    board[nx][ny] = 1; // 벽 처리
                    dis[nx][ny] = dis[temp.x][temp.y]+1; // 거리누적
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        BFS(1,1);
        if(dis[7][7] == 0){
            System.out.println("-1");
        }else{
            System.out.println(dis[7][7]);
        }
    }
}
