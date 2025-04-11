package BOJ;

import java.io.*;
import java.util.*;

public class sol1497_2 {
    static int n, m;
    static int minGuitar = Integer.MAX_VALUE;
    static int maxSong = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Guitar> guitarList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            guitarList.add(new Guitar(st.nextToken(), strToLong(st.nextToken())));
        }

        int mask = 1 << n;
        for (int i = 1; i < mask; i++) {    //  각 조합을 전부 탐색
            int guitarCnt = Integer.bitCount(i);
            int songCnt = 0;
            long playedSongs = 0;
            for (int j = 0; j < n; j++) {   //  사용된 기타로 연주 가능한 곡 탐색
                if ((i & 1 << j) != 0) {
                    Guitar guitar = guitarList.get(j);
                    playedSongs |= guitar.playableSongs;
                }
                songCnt = Long.bitCount(playedSongs);
            }
            if (songCnt == maxSong && guitarCnt < minGuitar) {
                minGuitar = guitarCnt;
            }
            if (songCnt > maxSong) {
                minGuitar = guitarCnt;
                maxSong = songCnt;
            }
        }

        System.out.println(maxSong == 0 ? -1 : minGuitar);
    }

    public static long strToLong(String song) {
        long sum = 0;
        for (int i = 0; i < m; i++) {
            char key = song.charAt(i);
            if (key == 'Y') {
                sum += 1L << i;
            }
        }
        return sum;
    }

    public static class Guitar {
        String name;
        long playableSongs;

        Guitar(String name, long playableSongs) {
            this.name = name;
            this.playableSongs = playableSongs;
        }
    }
}
