package leetcode;

import java.util.*;

/**
 * 1971. Find if Path Exists in Graph
 * https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/862368978/
 * solved: 2022-12-19
 */
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> nodes = new HashMap<>();

        createNodeMap(nodes, edges);

        return isPathExist(nodes, source, destination, new HashSet<Integer>());
    }

    private void createNodeMap(Map<Integer, Set<Integer>> nodes, int[][] edges) {
        for (int[] edge : edges) {
            if (!nodes.containsKey(edge[0]))
                nodes.put(edge[0], new HashSet<Integer>());

            if (!nodes.containsKey(edge[1]))
                nodes.put(edge[1], new HashSet<Integer>());

            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        // System.out.println(nodes.toString());
    }

    private boolean isPathExist(Map<Integer, Set<Integer>> nodes, int src, int dest, Set<Integer> visited) {
        // System.out.println("node: " + src);

        if (src == dest) {
            return true;
        } else {
            for (int connectedNode : nodes.get(src)) {
                if (!visited.contains(connectedNode)) {
                    visited.add(connectedNode);
                    if (isPathExist(nodes, connectedNode, dest, visited)) {
                        return true;
                    } else {
                        continue;
                    }
                } else {}
            }

            return false;
        }
    }
}
