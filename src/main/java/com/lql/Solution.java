package com.lql;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class Solution {
    boolean[] visited;
    boolean[] alreadTraverse;

    @Test
    public void test() {
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        alreadTraverse = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < graph.length; i++) {
            if (traverse(graph, i)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int w = edge[1], v = edge[0];
            graph[w].add(v);
        }
        return graph;
    }

    public boolean traverse(List<Integer>[] graph, int cur) {
        if (visited[cur] || alreadTraverse[cur]) {
            return false;
        }
        visited[cur] = true;
        for (int next : graph[cur]) {
            if (traverse(graph, next)) {
                return true;
            }
        }
        return false;
    }
}