package CodeTree;

import java.io.*;
import java.util.*;

public class sol4 {
    static class Gift implements Comparable<Gift> {
        int price;
        int shipping;
        int total;

        Gift(int price, int shipping) {
            this.price = price;
            this.shipping = shipping;
            this.total = price + shipping;
        }

        @Override
        public int compareTo(Gift other) {
            return this.total - other.total;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Gift[] gifts = new Gift[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int shipping = Integer.parseInt(st.nextToken());
            gifts[i] = new Gift(price, shipping);
        }

        Arrays.sort(gifts);

        int maxGifts = 0;
        for (int i = 0; i < n; i++) {
            int remainingBudget = b - (gifts[i].price / 2 + gifts[i].shipping);
            if (remainingBudget < 0) continue;

            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (remainingBudget >= gifts[j].total) {
                    remainingBudget -= gifts[j].total;
                    count++;
                } else {
                    break;
                }
            }
            maxGifts = Math.max(maxGifts, count);
        }

        System.out.println(maxGifts);
    }
}
