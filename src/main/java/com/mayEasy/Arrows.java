package com.mayEasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 5/6/17.
 */
public class Arrows {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        long t = Long.parseLong(stringTokenizer.nextToken());
        while(t-->0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            long n = Long.parseLong(stringTokenizer.nextToken());
            long q = 1;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while(n-->0) {
                q = lcm(q, Long.parseLong(stringTokenizer.nextToken()));
            }
            stringBuilder.append(q).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
    public static long gcd(long p, long q) {
        if (q == 0) return p;
        if (p == 0) return q;

        if ((p & 1) == 0 && (q & 1) == 0) return gcd(p >> 1, q >> 1) << 1;
        else if ((p & 1) == 0) return gcd(p >> 1, q);
        else if ((q & 1) == 0) return gcd(p, q >> 1);
        else if (p >= q) return gcd((p-q) >> 1, q);
        else return gcd(p, (q-p) >> 1);
    }
    public static long lcm(long a, long b) {
        return (a*b)/gcd(a,b);
    }
}
