package SofteerBootcamp;

import java.io.*;
import java.util.*;

public class sol {
    static String[] input;
    static Queue<Integer> pocket = new LinkedList<>();
    static Queue<Integer> trash = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = new String[100];
        input = br.readLine().split(" ");
        for (String s : input) {
            func(Integer.parseInt(s));
        }
        for(Integer i: trash){
            System.out.print(i + " ");
        }
    }

    public static void func(int item) {
        if(pocket.size() == 3){
            int old = pocket.poll();
            pocket.add(item);
            if(old != item){
                trash.add(old);
            }
        } else {
            pocket.add(item);
        }
    }
}
