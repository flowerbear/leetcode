package com.orlando.java.common;

import java.util.List;

public class Dijkstra {

    public Dijkstra(List<Integer>[] graph) {
        this.graph = graph;
    }
    List<Integer>[] graph;

    // 输入节点 s，返回 s 的相邻节点
    List<Integer> adj(int s) {
        return graph[s];
    }

    private class State {
        int id;
        int distFromStart;
        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
//    int weight(int from, int to);
//    int[] dijkstra(int start, List<Integer>[] graph) {
//
//    }
}
