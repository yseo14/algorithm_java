package BOJ;

import java.io.*;
import java.util.*;

public class sol20055_2 {
    static int n, k;
    static LinkedList<Belt> conveyor;
    static int brokenBelt;
    static int step = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        conveyor = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            int durability = Integer.parseInt(st.nextToken());
            conveyor.add(i, new Belt(false, durability));
        }

        while (brokenBelt < k) {
            step++;
            rotateBelt();
            exitRobot();
            moveRobots();
            putRobot();
        }

        System.out.println(step);
    }

    //  벨트 회전 메서드
    public static void rotateBelt() {
        conveyor.addFirst(conveyor.removeLast());
    }

    //  로봇 이동 메서드
    public static void moveRobots() {
        for (int i = n - 2; i > 0; i--) {
            Belt curr = conveyor.get(i);
            Belt next = conveyor.get(i + 1);
            if (!curr.isRobotOn) {  //  현재 칸에 로봇이 없으면 패스
                continue;
            }
            if (next.isRobotOn || next.durability < 1) {    //  다음 칸에 로봇이 있거나 내구도가 없어도 패스
                continue;
            }

            //  다음 칸으로 이동할 수 있으면
            next.durability--;  //  다음칸 내구도 감소
            next.isRobotOn = true;  //  다음칸으로 로봇 이동
            curr.isRobotOn = false;

            if (next.durability == 0) { //  이동한 칸이 내구도가 0이면
                brokenBelt++;   //  내구도 0인 칸 수 증가
            }

            if (i + 1 == n - 1) {   //  로봇이 내리는 위치로 이동하면 즉시 내림
                next.isRobotOn = false;
            }
        }
    }

    //  내리는 위치에 로봇 존재시 내리는 메서드
    public static void exitRobot() {
        Belt end = conveyor.get(n - 1);
        if (end.isRobotOn) {
            end.isRobotOn = false;
        }
    }

    //  올리는 위치에 로봇을 올리는 메서드
    public static void putRobot() {
        Belt start = conveyor.getFirst();
        if (start.durability >= 1) { //  내구도가 1이상이면
            start.isRobotOn = true; //  로봇을 올리고
            start.durability--; //  내구도 감소
            if (start.durability == 0) {    //  내구도를 내린 후 해당 칸의 내구도가 0이라면
                brokenBelt++;   //  내구도 0인 칸 수 증가
            }
        }
    }


    public static class Belt {
        boolean isRobotOn;
        int durability;

        Belt(boolean isRobotOn, int durability) {
            this.isRobotOn = isRobotOn;
            this.durability = durability;
        }
    }
}
