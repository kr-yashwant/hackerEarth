package com.aprilCircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 4/22/17.
 */
public class HelpFredo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());int j=n;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        BigInteger b= new BigInteger("0");
        BigInteger s= new BigInteger("1");
        while(n-->0) {
            BigInteger a = new BigInteger(stringTokenizer.nextToken());
            b = b.add(a);
            s = s.multiply(a);
        }
        b = b.divide(new BigInteger(""+j));
        while((b.pow(j)).compareTo(s) == -1) {
            b = b.add(new BigInteger("1"));
        }
        System.out.println(b);
    }
}
