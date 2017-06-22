package com.mayEasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by nfn8y on 5/6/17.
 */
public class PathDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int q = Integer.parseInt(stringTokenizer.nextToken());
        int tree[][] = new int[n+1][n+1];
        for(int i=0; i<n-1;i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            tree[a][b] = c;tree[b][a] = c;
        }
        CyclicBarrier barrier = new CyclicBarrier(q+1);
        for(int i=0; i<q; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            //System.out.println(req(tree, a));
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
class PathSolver implements Runnable {
    public PathSolver(int seq, int[][] t,int div, CyclicBarrier barrier, ConcurrentHashMap<Integer, Long> map) {
        this.seq = seq;
        this.t = t;
        this.arr = new int[t.length];
        this.barrier = barrier;
        this.map = map;
        this.div = div;
    }
    private int seq, t[][], arr[], div;long n=0; CyclicBarrier barrier;ConcurrentHashMap<Integer, Long> map;
    int[] list = new int[t.length];

    @Override
    public void run() {
        try {
            for (int i=0; i<t.length; i++)arr[i]=i;
            for(int i=1; i<t.length; i++) {
                for(int j=i; j<t.length; j++) {
                    if(t[i][j]%div==0) arr[j]=arr[i];
                }
            }
            for(int i=1; i<t.length; i++) {
                for(int e: arr) {

                }
            }
            map.put(seq, n);
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}