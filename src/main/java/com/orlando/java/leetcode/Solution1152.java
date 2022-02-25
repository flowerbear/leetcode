package com.orlando.java.leetcode;

import java.util.*;

public class Solution1152 {

  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
    int n = username.length;
    List<Pair> dates = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      dates.add(new Pair(username[i], timestamp[i], website[i]));
    }

    Collections.sort(dates, (a, b) -> a.time - b.time);
    HashMap<String, List<String>> userToWebs = new HashMap<>();

    for (Pair data : dates) {
      userToWebs.putIfAbsent(data.user, new ArrayList<String>());
      userToWebs.get(data.user).add(data.web);
    }

    HashMap<String, Integer> seqToCount = new HashMap<>();

    int maxCount = 0;
    String maxSeq = "";
    for (Map.Entry<String, List<String>> entry : userToWebs.entrySet()) {
      Set<String> seqCom = getCom(entry.getValue());
      for (String seq : seqCom) {
        seqToCount.put(seq, seqToCount.getOrDefault(seq, 0) + 1);
        if (seqToCount.get(seq) > maxCount) {
          maxCount = seqToCount.get(seq);
          maxSeq = seq;
        } else if (seqToCount.get(seq) == maxCount && seq.compareTo(maxSeq) < 0) {
          maxSeq = seq;
        }
      }
    }
    List<String> result = new ArrayList<>();
    String[] webs = maxSeq.split(",");
    for (String w : webs) {
      result.add(w);
    }
    return result;
  }

  private HashSet<String> getCom(List<String> webs) {
    HashSet<String> result = new HashSet<>();
    int n = webs.size();
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          result.add(webs.get(i) + "," + webs.get(j) + "," + webs.get(k));
        }
      }
    }

    return result;
  }

  private class Pair {
    String user;
    int time;
    String web;
    public Pair(String user, int time, String web) {
      this.user = user;
      this.time = time;
      this.web = web;
    }
  }
}
