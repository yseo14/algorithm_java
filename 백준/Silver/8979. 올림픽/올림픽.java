import java.io.*;
import java.util.*;

public class Main {
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ArrayList<Country> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Country(num, gold, silver, bronze));
        }
        Collections.sort(list);
        int rank = 1;
        if (list.get(0).num == k) {
            System.out.println(rank);
            return;
        }
        for (int i = 1; i < n; i++) {
            Country prev = list.get(i - 1);
            Country curr = list.get(i);
            if (!(prev.gold == curr.gold && prev.silver == curr.silver && prev.bronze == curr.bronze)) {
                rank = i + 1;
            }

            if (curr.num == k) {
                System.out.println(rank);
                return;
            }
        }
    }

    public static class Country implements Comparable<Country> {
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country country) {
            if (this.gold == country.gold) {
                if (this.silver == country.silver) {
                    return Integer.compare(country.bronze, this.bronze);
                }
                return Integer.compare(country.silver, this.silver);
            } else {
                return Integer.compare(country.gold, this.gold);
            }
        }
    }
}
