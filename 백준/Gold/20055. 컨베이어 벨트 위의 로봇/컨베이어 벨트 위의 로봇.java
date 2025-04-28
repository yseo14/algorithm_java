import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static LinkedList<Belt> conveyor;
    static int step = 0;
    static int brokenBelt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int size = 2 * n;
        conveyor = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int durability = Integer.parseInt(st.nextToken());
            conveyor.add(new Belt(false, durability));
        }

        while (k > brokenBelt) {
            rotateConveyor();
            moveRobot();
        }
        System.out.println(step);
    }

    public static void rotateConveyor() {
        step++;
        conveyor.addFirst(conveyor.removeLast());
        conveyor.get(n - 1).isRobotOn = false;  //  내리는 위치에 로봇이 있다면 내림

        if (conveyor.get(0).durability > 0) {   //  올리는 위치 내구도 1 이상이면 로봇 올림
            conveyor.get(0).isRobotOn = true;
            conveyor.get(0).durability--;
            if (conveyor.get(0).durability == 0) {
                brokenBelt++;
            }
        }
    }

    public static void moveRobot() {
        for (int i = n - 2; i > 0; i--) {
            Belt curr = conveyor.get(i);
            Belt next = conveyor.get(i + 1);
            if (!curr.isRobotOn) {  //  현재 칸에 이동시킬 로봇이 없으면 이동 불가
                continue;
            }

            if (next.isRobotOn || next.durability < 1) {    //  다음 칸에 로봇이 있거나 내구도가 없는 경우 이동 불가
                continue;
            }

            //  로봇 한칸 이동
            curr.isRobotOn = false;
            next.isRobotOn = true;
            next.durability--;
            if (next.durability == 0) {
                brokenBelt++;
            }

            if (i + 1 == n - 1) {
                conveyor.get(i + 1).isRobotOn = false;
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
