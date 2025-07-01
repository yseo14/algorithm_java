import java.io.*;
import java.util.*;

public class Main {
    static int nA, nB;
    static int[] arrA, arrB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        arrA = new int[nA];
        arrB = new int[nB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrB);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nA; i++) {
            if (Arrays.binarySearch(arrB, arrA[i]) < 0) {
                list.add(arrA[i]);
            }
        }
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
