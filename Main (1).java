package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File in = new File("input.txt");
        Scanner sc = new Scanner(in);
        File out = new File("output.txt");
        PrintWriter pw = new PrintWriter(out);
        int n = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        };
        int first;
        int firstBest = 0;
        int r = 0;
        int g = 0;
        int rBest = 0;
        int kol;
        int kolBest = -1;
        for (int i = 0; i < n; i++){
            first = a[i];
            kol = 1;
            for (int j = i; j < n; j++){
                if (i != j) {
                    r = a[j] - a[i];
                    g = j;
                    kol = 2;
                    for (int k = j; k < n; k++){
                        if (k != j) {
                            if (a[k] - a[g] == r) {
                                g = k;
                                kol++;
                            };
                        };
                    };
                    if (kol > kolBest){
                        kolBest = kol;
                        rBest = r;
                        firstBest = first;
                    };
                };
            };
        };
        if (kolBest == -1){
            kolBest = 1;
            firstBest = a[0];
        }
        pw.print(kolBest);
        pw.println();
        int z = 0;
        int y = 0;
        for (int i = 0; i < n; i++){
            if (a[i] == firstBest){
                y = i;
                z = i;
                pw.print(y + 1 + " ");
                break;
            };
        };
        for (int i = y; i < n; i++){
            if (i != y){
                if (a[i] - a[z] == rBest){
                    z = i;
                    pw.print(i + 1 + " ");
                };
            };
        };
        sc.close();
        pw.close();
    }
}