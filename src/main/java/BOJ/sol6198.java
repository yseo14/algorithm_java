package BOJ;

import java.io.*;
import java.util.*;

public class sol6198 {

    static Stack<Building> origin;
    static Stack<Building> temp;
    static int N;
    static Long result = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        origin = new Stack<>();
        temp = new Stack<>();
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            origin.push(new Building(i + 1, h));
        }
        for (int i = 0; i < N; i++) {
            Building curr = origin.pop();
            if (temp.isEmpty()) {
                temp.push(curr);
            } else {
                while (true) {
                    if (temp.isEmpty()) {
                        result += (N - curr.index);
                        temp.push(curr);
                        break;
                    }
                    Building next = temp.peek();
                    if (next.height < curr.height) {
                        temp.pop();
                    } else {
                        temp.push(curr);
                        result += (next.index - curr.index - 1);
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static class Building {
        int index;
        int height;
        public Building(int i, int h) {
            this.index = i;
            this.height = h;
        }
    }
}
