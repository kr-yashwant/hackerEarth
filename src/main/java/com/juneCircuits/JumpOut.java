package com.juneCircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 6/22/17.
 */
public class JumpOut {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<n; i++) {
            int ai = Integer.parseInt(stringTokenizer.nextToken());
            if(i+ai+1 > n) {
                System.out.println(i+1); break;
            }
        }
    }
}
