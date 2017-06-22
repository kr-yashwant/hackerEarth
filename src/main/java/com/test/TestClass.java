package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by nfn8y on 5/20/17.
 */
public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        AtomicBoolean b = new AtomicBoolean(true);
        int n = Integer.parseInt(stringTokenizer.nextToken()),
                m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[n][n];
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        CyclicBarrier barrier = new CyclicBarrier(n+1);
        for(int i=0; i<m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i][0] = Integer.parseInt(stringTokenizer.nextToken())-1;
            arr[i][1] = Integer.parseInt(stringTokenizer.nextToken())-1;
        }
        boolean mark = true;
        for(int i=0; i<n; i++) {
            executorService.submit(new Solution(arr, i, n, barrier, b));
        }
        barrier.await();
        System.out.println(mark?"Safe":"Unsafe");
        executorService.shutdownNow();
    }
}
class Solution implements Runnable {
    int[][] arr; int rogue; int tot; CyclicBarrier barrier;AtomicBoolean b;

    public Solution(int[][] arr, int rogue, int tot, CyclicBarrier barrier, AtomicBoolean b) {
        this.arr = arr; this.rogue = rogue; this.tot = tot; this.barrier = barrier; this.b = b;
    }
    @Override
    public void run() {
        DJS djs = new DJS(tot);
        for(int i=0; i<arr.length; i++) {
            if (!(arr[i][0] == rogue || arr[i][1] == rogue)) {
                djs.union(arr[i][0], arr[i][1]);
            }
        }
        b.set(b.get()&djs.isAllConnected());
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
class DJS
{
    int[] rank, parent;
    int n;
    public DJS(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }
    void makeSet() {
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    int find(int x) {
        if (parent[x]!=x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot)
            return;
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
    boolean isAllConnected() {
        int mark1 = parent[0]; int mark2 = mark1; int mark=0;
        for(int i=1; i<parent.length; i++){
            if(mark1 != parent[i] && mark2 !=parent[i]){
                mark2 = parent[i]; mark++;
            }
        }
        return mark<=1;
    }
}
