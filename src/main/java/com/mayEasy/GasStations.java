package com.mayEasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 5/6/17.
 */
public class GasStations {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        long x = Long.parseLong(stringTokenizer.nextToken());
        int i = 0; stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while(i<n) {
            long p = Long.parseLong(stringTokenizer.nextToken());
            if(x>p) {
                x -= p; i++;
            } else break;
        }
        System.out.print(i+1);
    }
}
