package com.orlando.java.self001.from301to350;

import java.util.*;

/*
 * Reconstruct Itinerary
 *
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival
 * airports of one flight. Reconstruct the itinerary in order and return it.
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are
 * multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a
 * single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 *
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 *
 */
public class Solution0332 {

  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> targets = new HashMap<>();

    for (List<String> ticket : tickets) {
      targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
    }

    List<String> router = new LinkedList<>();
    Stack<String> stack = new Stack<>();
    stack.push("JFK");
    while (!stack.isEmpty()) {
      while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
        stack.push(targets.get(stack.peek()).poll());
      }

      router.add(0, stack.pop());
    }
    return router;
  }


  HashMap<String, PriorityQueue<String>> adjMap = new HashMap<>();
  List<String> res = new LinkedList<>();

  public List<String> findItineraryDFS(List<List<String>> tickets) {

    for (List<String> ticket : tickets) {
      adjMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
    }
    dfs("JFK");
    return res;
  }

  private void dfs(String start) {
    while (adjMap.containsKey(start) && !adjMap.get(start).isEmpty()) {
      dfs(adjMap.get(start).poll());
    }
    res.add(0, start);
  }
}

