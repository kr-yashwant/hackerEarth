package com.mayEasy;

import java.util.Arrays;

/**
 * Created by nfn8y on 5/17/17.
 */
public class DisjointSet {
    int[] parent; int[] rank; int n;

    public DisjointSet(int n) {
        this.parent = new int[n]; this.rank = new int[n]; this.n = n;
        construct();
    }
    void construct() {
        for(int i=0; i<n; i++) parent[i] = i;
    }
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        } else {
            int result = find(parent[i]);
            parent[i]= result;//Caching for Tree height compression
            return result;
        }
    }
    public void union(int x, int y) {
        int rX = find(x), rY = find(y);
        if(rX==rY) return;
        int rankX = rank[rX], rankY = rank[rY];
        if(rankX<rankY) this.parent[rX] = rY;
        else if(rankX>rankY) this.parent[rY] = rX;
        else {
            this.parent[rY] = rX; rank[rX] = rank[rX]+1;
        }
    }
    public int noOfDistinctPaths() {
        Arrays.sort(parent);
        System.out.println(Arrays.toString(parent));
        int temp = -1, n0=1;
        for(int i=0; i<n;i++) {
            if(parent[i]==temp) {
                n0++;
            } else {
                if(n0==1) n+=1;
                else n+= (int)(n*(n-1)/2);
                temp = parent[i];n0=0;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        DisjointSet dj = new DisjointSet(3);
        dj.union(1,2);
        System.out.println(dj.noOfDistinctPaths());
    }
}
