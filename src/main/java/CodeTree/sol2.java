package CodeTree;

import java.io.*;
import java.util.*;

/**
 * A 에서 연속 부분 수열을 뽑고 오름차순으로 정렬한다.
 * 수열 B를 오름차순으로 정렬한다.
 * 두 개를 비교해서 같으면 인덱스 저장, count +
 */
public class sol2 {
    static int n, m;
    static int[] a, b;
    static int count = 0;
    static ArrayList<Integer> index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }
        m = Integer.parseInt(br.readLine());
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(b);

        index = new ArrayList<>();
        for (int i = 0; i <= n - m; i++) {
            int[] subArray = new int[m];
            int firstIdx = i;
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                subArray[j] = a[firstIdx];
                firstIdx++;
            }
            Arrays.sort(subArray);
            int gap = subArray[0] - b[0];
            for (int j = 1; j < m; j++) {
                if ((subArray[j] - b[j]) != gap) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                index.add(i+1);
                count++;
            }
        }

        System.out.println(count);
        for (int i = 0; i < index.size(); i++) {
            System.out.println(index.get(i));
        }
    }
}
