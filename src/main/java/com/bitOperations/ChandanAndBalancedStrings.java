package com.bitOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 6/21/17.
 */
public class ChandanAndBalancedStrings {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int t = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder stringBuilder = new StringBuilder();
        while (t-->0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char a[] = stringTokenizer.nextToken().toCharArray();
            List<Integer> list = new ArrayList<>();
            int xor = a[0];
            list.add(xor);
            for(int i=1; i<a.length; i++) {
                xor ^= a[i];
                list.add(xor);
            }
            list.add(0);
            Collections.sort(list);
            stringBuilder.append(count(list)).append("\n");
        }
        System.out.print(stringBuilder.toString());
    }
    public static long count(List<Integer> list) {

        int i=0, val; long ans = 0;
        while(i<list.size()){
            val = list.get(i) ;
            long cnt = 0;
            while(i<list.size() && val == list.get(i)){
                cnt ++ ;
                i ++ ;
            }
            ans = ans + (cnt*(cnt-1))/2 ;
        }
        return ans;
    }
}
