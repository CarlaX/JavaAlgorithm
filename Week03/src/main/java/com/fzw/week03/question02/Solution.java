package com.fzw.week03.question02;

import java.util.*;

/**
 * @author fzw
 * @description 210. 课程表 II
 * @date 2021-07-07
 **/
public class Solution {
    List<List<Integer>> edges;
    int[] visited;
    Deque<Integer> stack;
    boolean valid;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        visited = new int[numCourses];
        stack = new ArrayDeque<>();
        valid = true;
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        stack.offerLast(u);
    }
}