import java.io.*;
import java.util.*;

public class Main {
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

    public static void rotateBelt() {
        conveyor.addFirst(conveyor.removeLast());
    }

    public static void moveRobots() {
        for (int i = n - 2; i > 0; i--) {
            Belt curr = conveyor.get(i);
            Belt next = conveyor.get(i + 1);
            if (!curr.isRobotOn) {
                continue;
            }
            if (next.isRobotOn || next.durability < 1) {
                continue;
            }
            next.durability--;
            next.isRobotOn = true;
            curr.isRobotOn = false;

            if (next.durability == 0) {
                brokenBelt++;
            }

            if (i + 1 == n - 1) {   //  로봇이 내리는 위치로 이동하면 즉시 내림
                next.isRobotOn = false;
            }
        }
    }

    public static void exitRobot() {
        Belt end = conveyor.get(n - 1);
        if (end.isRobotOn) {
            end.isRobotOn = false;
        }
    }

    public static void putRobot() {
        Belt start = conveyor.getFirst();
        if (start.durability > 0) {
            start.isRobotOn = true;
            start.durability--;
            if (start.durability == 0) {
                brokenBelt++;
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
