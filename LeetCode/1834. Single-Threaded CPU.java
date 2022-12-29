package leetcode;

import java.util.*;

/**
 * 1834. Single-Threaded CPU
 * https://leetcode.com/problems/single-threaded-cpu/submissions/867729311/
 * solved: 2022-12-29
 */
class Solution {
    private class Task {
        int index;
        int enqueueTime;
        int processTime;

        Task(int index, int enqueueTime, int processTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processTime = processTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        List<Task> taskList = new LinkedList<>();
        List<Integer> taskOrderList = new ArrayList<>();
        int currentTime = 0;

        // create new sorted list containing indices
        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        taskList.sort((t1, t2) -> t1.enqueueTime - t2.enqueueTime);

        // define a heap to get the highest priority task
        Queue<Task> availableTaskQueue = new PriorityQueue<>((t1, t2) -> {
            if (t1.processTime == t2.processTime) {
                return t1.index - t2.index;
            } else {
                return t1.processTime - t2.processTime;
            }
        });

        while (!taskList.isEmpty() || !availableTaskQueue.isEmpty()) {
            // no availableTask means idle state, so update time for next task
            if (availableTaskQueue.isEmpty()) {
                currentTime = Math.max(currentTime, taskList.get(0).enqueueTime);
            }

            // add available tasks into heap
            while (!taskList.isEmpty() && currentTime >= taskList.get(0).enqueueTime) {
                availableTaskQueue.add(taskList.get(0));
                taskList.remove(0);
            }

            // process one highest priority task
            taskOrderList.add(availableTaskQueue.peek().index);
            currentTime += availableTaskQueue.poll().processTime;
        }

        return taskOrderList.stream().mapToInt(i -> i).toArray();
    }
}
