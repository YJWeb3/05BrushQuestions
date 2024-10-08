package com.wclass.structalgorithm.sort_08_union_find.leetcode_nowcoder.d6_min_spread_malicious_software‌_II;

import java.util.*;

/**
 * @program: StructAlgorithm
 * @ClassName UnionFindSetS8D6
 * @description:
 * @author: W哥
 * @create: 2024-10-02-16-08
 * @Version 1.0
 **/
public class UnionFindSetS8D6 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int N = graph.length;
        DSU dsu = new DSU(N);

        // clean[u] == 1 if its a node in the graph not in initial.
        int[] clean = new int[N];
        Arrays.fill(clean, 1);
        for (int x: initial) clean[x] = 0;

        for (int u = 0; u < N; ++u) if (clean[u] == 1)
            for (int v = 0; v < N; ++v) if (clean[v] == 1)
                if (graph[u][v] == 1)
                    dsu.union(u, v);

        // dsu now represents the components of the graph without
        // any nodes from initial.  Let's call this graph G.
        int[] count = new int[N];
        Map<Integer, Set<Integer>> nodeToCompo = new HashMap();
        for (int u: initial) {
            Set<Integer> components = new HashSet();
            for (int v = 0; v < N; ++v) if (clean[v] == 1) {
                if (graph[u][v] == 1)
                    components.add(dsu.find(v));
            }

            nodeToCompo.put(u, components);
            for (int c: components)
                count[c]++;
        }

        // For each node u in initial, nodeToCompo.get(u)
        // now has every component from G that u neighbors.

        int ans = -1, ansSize = -1;
        for (int u: nodeToCompo.keySet()) {
            Set<Integer> components = nodeToCompo.get(u);
            int score = 0;
            for (int c: components)
                if (count[c] == 1) // uniquely infected
                    score += dsu.size(c);

            if (score > ansSize || score == ansSize && u < ans) {
                ansSize = score;
                ans = u;
            }
        }

        return ans;
    }
}


class DSU {
    int[] p, sz;

    DSU(int N) {
        p = new int[N];
        for (int x = 0; x < N; ++x)
            p[x] = x;

        sz = new int[N];
        Arrays.fill(sz, 1);
    }

    public int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

    public void union(int x, int y) {
        int xr = find(x);
        int yr = find(y);
        p[xr] = yr;
        sz[yr] += sz[xr];
    }

    public int size(int x) {
        return sz[find(x)];
    }
}