import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] board = new int[40][40]; //  노트북
    static int R, C;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int cnt = 0; cnt < K; cnt++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[10][10];  //  스티커

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 4; i++) {
                boolean isAttached = false;
                for (int x = 0; x <= N - R; x++) {
                    if (isAttached) {
                        break;
                    }
                    for (int y = 0; y <= M - C; y++) {
                        if (isAttachable(x, y,sticker)) {
                            isAttached = true;
                            break;
                        }
                    }
                }
                if (isAttached) {
                    break;
                }
                sticker = rotate90(sticker);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isAttachable(int x, int y, int[][] sticker) {  //  노트북에 스티커를 붙일 수 있는지 확인
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[x + i][y + j] == 1 && sticker[i][j] == 1) {   //  붙일 수 없을 경우
                    return false;
                }
            }
        }
        for (int i = 0; i < R; i++) {   //  붙일 수 있으면 노트북에 붙이고 표시
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] == 1) {
                    board[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    public static int[][] rotate90(int[][] sticker) {

        int[][] rotated = new int[10][10];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rotated[j][R - 1 - i] = sticker[i][j];
            }
        }
        int T = R;
        R =C;
        C = T;
        return rotated;
    }
}

