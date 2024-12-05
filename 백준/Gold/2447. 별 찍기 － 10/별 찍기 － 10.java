import java.io.*;

public class Main {
    static int N;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            bw.write(map[i]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void star(int r, int c, int size, boolean blank) {
        if (blank) {
            for (int i = r; i < r + size; i++) {
                for (int j = c; j < c + size; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }
        if (size == 1) {
            map[r][c] = '*';
            return;
        }

        int nSize = size / 3;
        int count = 0;
        for (int i = r; i < r + size; i += nSize) {
            for (int j = c; j < c + size; j+=nSize) {
                count++;
                if (count == 5) {
                    star(i, j, nSize, true);
                }else{
                    star(i, j, nSize, false);
                }
            }
        }
    }
}

