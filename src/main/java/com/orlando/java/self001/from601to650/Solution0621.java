package com.orlando.java.self001.from601to650;

public class Solution0621 {

    public int leastInterval(char[] tasks, int n) {
        int max = 0, maxCount = 0, counter[] = new int[26];
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) maxCount++;
            else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1, partLength = n - (maxCount - 1), emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount, idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}

