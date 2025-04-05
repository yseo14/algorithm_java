package BOJ;

import java.io.*;
import java.util.*;

public class sol1497 {
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

    /**
     *
     * @param guitarList: 기타 목록
     * @param idx: 선택할 기타의 인덱스
     * @param playedSong: 지금까지 선택한 기타들로 연주 가능한 노래 bit
     * @param guitarCnt: 선택한 기타 수
     */
    public static void func(ArrayList<Guitar> guitarList, int idx, long playedSong, int guitarCnt) {
        int played = Long.bitCount(playedSong); //  1의 개수를 카운트 -> 지금까지 연주 가능한 노래 수
        if (played == maxSong && minGuitar > guitarCnt) {   //  연주 가능한 노래 수가 최대와 같고, 선택한 기타 수는 더 적을 경우
            minGuitar = guitarCnt;
        }
        if (played > maxSong) { //  연주 가능한 노래 수가 최대보다 클 경우
            maxSong = played;
            minGuitar = guitarCnt;
        }
        if (idx == n || played == m) {  //  마지막 기타까지 탐색 완료했거나, 모든 노래를 연주 가능하다면 종료
            return;
        }

        //  현재 기타를 선택할 경우
        func(guitarList, idx + 1, playedSong | guitarList.get(idx).playableSongs, guitarCnt + 1);
        //  현재 기타를 선택하지 않고 건너뛰는 경우
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
