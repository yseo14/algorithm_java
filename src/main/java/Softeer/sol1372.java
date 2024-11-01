package Softeer;

import java.io.*;
import java.util.*;

public class sol1372 {
    static final String ASCENDING = "ascending";
    static final String DESCENDING = "descending";
    static final String MIXED = "mixed";
    static List<Integer> input;
    static List<Integer> ascending;
    static List<Integer> descending;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = new ArrayList<Integer>();
        for(int i = 0;i<8;i++){
            input.add(Integer.parseInt(st.nextToken()));
        }
        ascending = new ArrayList<>(input);
        descending = new ArrayList<>(input);
        Collections.sort(ascending);
        descending.sort(Comparator.reverseOrder());

        if(input.equals(ascending)){
            System.out.println(ASCENDING);
        } else if(input.equals(descending)){
            System.out.println(DESCENDING);
        } else {
            System.out.println(MIXED);
        }

    }
}
