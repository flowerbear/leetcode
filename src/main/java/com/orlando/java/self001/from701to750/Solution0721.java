package com.orlando.java.self001.from701to750;

import java.util.*;

public class Solution0721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> data = accounts.get(i);
            for (int j = 1; j < data.size(); j++) {
                String email = data.get(j);
                maps.computeIfAbsent(email, k -> new ArrayList<Integer>()).add(i);
            }
        }

        boolean[] visited = new boolean[n];
        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Set<String> set = new TreeSet<>();
            dfs(i, accounts, maps, visited, set);
            if (!set.isEmpty()) {
                List<String> list = new LinkedList<>(set);
                list.add(0, accounts.get(i).get(0));
                res.add(list);
            }
        }
        return res;
    }

    private void dfs(int cur, List<List<String>> accounts, Map<String, List<Integer>> maps, boolean[] visited, Set<String> set) {
        if (visited[cur]) return;
        visited[cur] = true;
        for (int i = 1; i < accounts.get(cur).size(); i++) {
            String email = accounts.get(cur).get(i);
            set.add(email);
            for (int index : maps.get(email)) {
                dfs(index, accounts, maps, visited, set);
            }
        }
    }
}

