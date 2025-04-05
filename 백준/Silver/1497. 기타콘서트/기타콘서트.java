import java.io.*;
import java.util.*;

public class Main {
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
        func(guitarList, 0, 0, 0);
        System.out.println(maxSong == 0 ? -1 : minGuitar);
    }

    public static void func(ArrayList<Guitar> guitarList, int idx, long playedSong, int guitarCnt) {
        int played = Long.bitCount(playedSong);
        if (played == maxSong && minGuitar > guitarCnt) {
            minGuitar = guitarCnt;
        }
        if (played > maxSong) {
            maxSong = played;
            minGuitar = guitarCnt;
        }
        if (idx == n || played == m) {
            return;
        }

        func(guitarList, idx + 1, playedSong | guitarList.get(idx).playableSongs, guitarCnt + 1);
        func(guitarList, idx + 1, playedSong, guitarCnt);
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
