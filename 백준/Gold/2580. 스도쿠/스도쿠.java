import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0,0);
    }

    public static void sudoku(int row, int col) {
        if (col == 9) { //  하나의 행이 다 채워지면 다음 열로 이동
            sudoku(row + 1, 0);
            return;
        }

        if (row == 9) { //  모든 열과 행이 다 채워지면 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (board[row][col] == 0) { //  빈 칸을 만나면
            for (int i = 1; i <= 9; i++) {   //  1~9까지 넣을 수 있는지 체크
                if (check(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row, col + 1);   //  넣을 수 있으면 다음 칸으로 이동
                }
            }
            board[row][col] = 0;    //  1~9 모두 불가능하다 -> 이전 칸이 잘못 되었다. 다시 현재 칸을 0으로 돌리고 재귀 호출 지점으로 복귀
            return;
        }

        //  빈 칸이 아니라면 다음 칸으로 이동
        sudoku(row, col + 1);
    }

    public static boolean check(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        int setRow = (row / 3) * 3;
        int setCol = (col / 3) * 3;
        for (int i = setRow; i < setRow + 3; i++) {
            for (int j = setCol; j < setCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
