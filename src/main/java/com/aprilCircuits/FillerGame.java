package com.aprilCircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 4/25/17.
 */
public class FillerGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int q = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder out = new StringBuilder();
        while(q-->0) {
            boolean z = false;
            for(int i=0; i<n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String s = stringTokenizer.nextToken();
                for (int j=0; j<s.length(); j++) {
                    if(s.charAt(j)=='0') z=!z;
                }
            }
            out.append(z?0:1).append("\n");
        }
        System.out.print(out.toString());
    }
}
