package com.aprilCircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 4/30/17.
 */
public class NumberSummation {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long n = Long.parseLong(stringTokenizer.nextToken()); int MOD = 1000000007;
        long sqrt = (long)Math.sqrt(n);
        long sum = 0;
        for(int i=1; i<=sqrt; i++){
            sum  = 	(sum + ((((i * (i + (n / i) % MOD))%MOD) * (MOD+(n/i)%MOD+1-i)%MOD)%MOD)) % MOD;

        }
        long num = ((sqrt*(sqrt+1))%MOD * (2*sqrt+1)%MOD)%MOD;
        long factor = inverseModullo(num, 6, MOD);
        System.out.println(( MOD + sum - factor )%MOD );
    }
    static long expo(long a, long b, long MOD){
        long result = 1;
        while (b>0){
            if (b%2==1) result=(result*a)%MOD;
            b>>=1;
            a=(a*a)%MOD;
        }
        return result%MOD;
    }
    static long inverseModullo(long numerator, long denominator, long MOD){
        return ((numerator%MOD)*(expo(denominator, MOD-2, MOD)))%MOD;
    }
}
