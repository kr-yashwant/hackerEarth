package com.aprilCircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 4/22/17.
 */
public class FredoAndGame {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(stringTokenizer.nextToken());
        while(t-->0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int i = 0, arr[] = new int[n];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<n; j++) {
                arr[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            while(a!=0 && i<n) {
                int r = Integer.parseInt(stringTokenizer.nextToken());
                if(r==1) {
                    a+=2;
                } else {
                    a--;
                }
            }

        }
        System.out.print(builder.toString());
    }
}
