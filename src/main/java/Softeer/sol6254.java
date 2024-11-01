package Softeer;

import java.io.*;
import java.util.*;

public class sol6254 {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String startAt = st.nextToken();
            String endAt = st.nextToken();
            result += workTime(startAt, endAt);
        }
        System.out.println(result);
    }

    public static int workTime(String start, String end) {
        int startMin = toMinute(start);
        int endMin = toMinute(end);
        return endMin - startMin;
    }

    public static int toMinute(String time) {
        String[] workAt = time.split(":");
        int minute = Integer.parseInt(workAt[0]) * 60 + Integer.parseInt(workAt[1]);
        return minute;
    }
}
