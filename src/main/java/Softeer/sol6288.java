package Softeer;

import java.io.*;
import java.util.*;

public class sol6288 {
    static int W, N;
    static List<Metal> metals;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        metals = new ArrayList<Metal>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            metals.add(new Metal(weight, price));
        }

        metals.sort((m1, m2) -> Integer.compare(m2.price, m1.price));
        for (Metal m : metals) {
            int weight = m.weight;
            int price = m.price;
            if (W < weight) {
                result += price * W;
                W = 0;
                break;
            }
            result += price * weight;
            W -= weight;
        }
        System.out.println(result);
    }

    public static class Metal {
        int weight;
        int price;

        public Metal(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
