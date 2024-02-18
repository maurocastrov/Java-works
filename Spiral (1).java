
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> arrayList = new ArrayList<>();
        File in = new File("input.txt");
        Scanner sc = new Scanner(in);
        File out = new File("output.txt");
        PrintWriter pw = new PrintWriter(out);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int r = 0;
        while (n != 0) {
            if (s == 1) {
                int k;
                if (r == 0) {
                    k = n * n;
                } else {
                    k = (n - 1) * (n - 1) + 1;
                }
                for (int i = 0; i < n; i++) {
                    pw.print(k + " ");
                    k--;
                }
                int p = arrayList.size();
                if (p != 0) {
                    for (int i = 0; i < p; i++) {
                        pw.print(arrayList.get(i) + " ");
                    }
                }
                n = 0;
            } else if (s == n) {
                int k = (n - 1) * (n - 1) - (n - 2);
                for (int i = 0; i < n; i++) {
                    pw.print(k + " ");
                    k++;
                }
                int p = arrayList.size();
                if (p != 0) {
                    for (int i = 0; i < p; i++) {
                        pw.print(arrayList.get(i) + " ");
                    }
                }
                n = 0;
            } else {
                int j;
                if (r == 0) {
                    j = (n - 1) * (n - 1) + 1 + (n - s);
                    arrayList.add(0, Integer.toString(j));
                    n--;
                    s--;
                } else {
                    j = n * n - (n - 1) - (n - s);
                    pw.print(j + " ");
                    n--;
                }
                if (r == 0) {
                    r = 1;
                } else {
                    r = 0;
                }
            }
        }
        sc.close();
        pw.close();
    }
}