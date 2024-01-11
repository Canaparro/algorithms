package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, LinkedList<Integer>> vertices = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int requirement = prerequisites[i][1];
            vertices.computeIfAbsent(course, k -> new LinkedList<>());
            vertices.get(course).add(requirement);
        }

        for(int i = 0; i < numCourses; i++) {
            boolean isAcyclic = dfs(i, vertices, new HashSet<>());
            if(!isAcyclic) {
                return false;
            }
        }

        return true;
    }

    // 1 [0]

    // 1

    private boolean dfs(int course, Map<Integer, LinkedList<Integer>> vertices, Set<Integer> visited) {
        if(!visited.add(course)) {
            return false;
        }

        LinkedList<Integer> requirements = vertices.get(course);

        if(requirements == null || requirements.isEmpty()) {
            return true;
        }

        while(!requirements.isEmpty()) {
            int requirement = requirements.getFirst();
            boolean isAcyclic = dfs(requirement, vertices, visited);
            if(!isAcyclic) {
                return false;
            }
            requirements.removeFirst();
        }
        return true;
    }
}
