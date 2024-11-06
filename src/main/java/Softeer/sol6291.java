package Softeer;

import java.io.*;
import java.util.*;

public class sol6291 {
    static int N;
    static List<Lecture> lectures;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lectures = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(s, f));
        }

        lectures.sort((l1, l2) -> Integer.compare(l1.f, l2.f));

        int currTime = 0;
        for (Lecture l : lectures) {
            if (currTime > l.s) {
                continue;
            }
            currTime = l.f;
            result++;
        }
        System.out.println(result);
    }

    public static class Lecture {
        int s;
        int f;

        public Lecture(int s, int f) {
            this.s = s;
            this.f = f;
        }
    }
}
